package com.shann.splitwise.strategy.impl;

import com.shann.splitwise.entities.Expense;
import com.shann.splitwise.entities.ExpenseUser;
import com.shann.splitwise.entities.User;
import com.shann.splitwise.enums.ExpenseUserType;
import com.shann.splitwise.models.Transaction;
import com.shann.splitwise.models.TransactionPair;
import com.shann.splitwise.strategy.SettleUpStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

@Slf4j
@Component
public class HeapSettleUpStrategy implements SettleUpStrategy {

    Map<User, Double> userBalances;
    // Create a min heap and max heap
    Queue<TransactionPair> minHeap = new PriorityQueue<>((a, b) -> Double.compare(a.getAmount(), b.getAmount()));
    Queue<TransactionPair> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.getAmount(), a.getAmount()));
    List<Transaction> transactions;

    /**
     * Write the algorithm
     * Find balances of each user (+ for lender, - for borrower)
     * Take 2 heaps - one min heap and one max heap
     * Keep popping one(min balance from min heap) one(max balance from max heap) element from both till both becomes empty
     * Keep adding the corresponding txns to the list of txn
     * return list
     */

    @Override
    public List<Transaction> settleUpExpenses(List<Expense> expenses) {
        userBalances = new HashMap<>();
        for (var expense : expenses) {
            for (var expenseUser : expense.getExpenseUsers()) {
                userBalances.put(expenseUser.getUser(), userBalances.getOrDefault(expenseUser.getUser(), 0.0) + (expenseUser.getExpenseUserType().equals(ExpenseUserType.LENDER) ? expenseUser.getAmount() : -expenseUser.getAmount()));
            }
        }

        // Add all the balances to the heaps
        insertInHeap();
        // while both heaps are not empty
        transactions = new ArrayList<>();
        executeTransaction();
        return transactions;
    }

    /**
     * This method is used to settle up transactions for a user.
     * Currently, it returns an empty list as a placeholder.
     *
     * @param expenseUsers The list of expense users for which to settle up transactions.
     * @return A list of transactions after settling up.
     */

    @Override
    public List<Transaction> settleUpExpenseUsers(List<ExpenseUser> expenseUsers) {
        // Add balances of each user to the map
        userBalances = new HashMap<>();
        expenseUsers.forEach(expenseUser -> {
            var user = expenseUser.getUser();
            var amount = expenseUser.getAmount();
            if (expenseUser.getExpenseUserType().equals(ExpenseUserType.LENDER))
                userBalances.put(user, userBalances.getOrDefault(user, 0.0) + amount);
            else userBalances.put(user, userBalances.getOrDefault(user, 0.0) - amount);
        });
        // Add all the balances to the heaps
        insertInHeap();
        // while both heaps are not empty
        transactions = new ArrayList<>();
        executeTransaction();
        return transactions;
    }

    /**
     * This method is used to insert the user balances into the heaps.
     * It iterates through the userBalances map and adds each entry to the appropriate heap based on the balance.
     */
    private void insertInHeap() {
        for (var entry : userBalances.entrySet()) {
            if (entry.getValue() > 0) {
                maxHeap.add(new TransactionPair(entry.getKey(), entry.getValue()));
            } else if (entry.getValue() < 0) {
                minHeap.add(new TransactionPair(entry.getKey(), entry.getValue()));
            }
        }
    }


    /**
     * This method is used to execute the transactions between the users.
     * It keeps popping one(min balance from min heap) one(max balance from max heap) element from both till both becomes empty
     * Keep adding the corresponding txns to the list of txn
     */

    private void executeTransaction() {
        while (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
            var minBalance = minHeap.poll();
            var maxBalance = maxHeap.poll();
            // create a transaction for the min and max balance
            var transaction = new Transaction();
            transaction.setFromUser(minBalance.getUser());
            transaction.setToUser(maxBalance.getUser());
            transaction.setAmount(Math.min(minBalance.getAmount(), maxBalance.getAmount()));
            // add to the list of transactions
            transactions.add(transaction);
        }
    }
}
