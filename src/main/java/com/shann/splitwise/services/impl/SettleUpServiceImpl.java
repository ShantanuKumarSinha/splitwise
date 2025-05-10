package com.shann.splitwise.services.impl;

import com.shann.splitwise.exceptions.GroupNotFoundException;
import com.shann.splitwise.exceptions.UserNotFoundException;
import com.shann.splitwise.models.Transaction;
import com.shann.splitwise.repositories.ExpenseRepository;
import com.shann.splitwise.repositories.ExpenseUserRepository;
import com.shann.splitwise.repositories.GroupRepository;
import com.shann.splitwise.repositories.UserRepository;
import com.shann.splitwise.services.SettleUpService;
import com.shann.splitwise.strategy.SettleUpStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SettleUpServiceImpl is a service class that implements the SettleUpService interface.
 * It provides methods to settle up transactions for a group or a user.
 */
@Service
public class SettleUpServiceImpl implements SettleUpService {

    /**
     * Repositories for accessing data related to expenses, users, and groups.
     */
    private ExpenseRepository expenseRepository;
    private UserRepository userRepository;
    private ExpenseUserRepository expenseUserRepository;
    private GroupRepository groupRepository;
    /**
     * Strategy for settling up transactions.
     */
    private SettleUpStrategy settleUpStrategy;

    /**
     * Constructor for SettleUpServiceImpl.
     *
     * @param expenseRepository     Repository for accessing expense data.
     * @param userRepository        Repository for accessing user data.
     * @param expenseUserRepository Repository for accessing expense-user data.
     * @param groupRepository       Repository for accessing group data.
     */
    public SettleUpServiceImpl(ExpenseRepository expenseRepository, UserRepository userRepository, ExpenseUserRepository expenseUserRepository, GroupRepository groupRepository, SettleUpStrategy settleUpStrategy) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
        this.expenseUserRepository = expenseUserRepository;
        this.groupRepository = groupRepository;
        this.settleUpStrategy = settleUpStrategy;
    }

    /**
     * This method is used to settle up transactions for a group.
     * Currently, it returns an empty list as a placeholder.
     *
     * @param groupId The ID of the group for which to settle up transactions.
     * @return A list of transactions after settling up.
     */
    @Override
    public List<Transaction> settleUpGroup(Integer groupId) throws GroupNotFoundException {
        // Fetch the group and its expenses
        var group = groupRepository.findById(groupId).orElseThrow(GroupNotFoundException::new);
        // Fetch all expenses associated with the group
        var expenses = expenseRepository.findAllByGroup(group);
        // settle up the expenses using the strategy
        return settleUpStrategy.settleUpExpenses(expenses);
    }

    /**
     * This method is used to settle up transactions for a user.
     * Currently, it returns an empty list as a placeholder.
     *
     * @param userId The ID of the user for which to settle up transactions.
     * @return A list of transactions after settling up.
     */
    @Override
    public List<Transaction> settleUpUser(Integer userId) throws UserNotFoundException {
        // Fetch the user and their expenses
        var user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        // Fetch all expenses associated with the user
        var expenseUsers = expenseUserRepository.findAllByUser(user);
        // Create a list of expenses from the expenseUsers
//        List<Expense> expenses = new ArrayList<>();
//        expenseUsers.forEach(expenseUser -> expenses.add(expenseUser.getExpense()));
        // settle up the expenses using the strategy
//        return settleUpStrategy.settleUpExpenses(expenses);

        // settle up the expense users using the strategy
        return settleUpStrategy.settleUpExpenseUsers(expenseUsers);
    }
}
