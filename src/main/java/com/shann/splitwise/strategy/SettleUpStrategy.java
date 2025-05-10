package com.shann.splitwise.strategy;

import com.shann.splitwise.entities.Expense;
import com.shann.splitwise.entities.ExpenseUser;
import com.shann.splitwise.models.Transaction;

import java.util.List;

public interface SettleUpStrategy {

    List<Transaction> settleUpExpenses(List<Expense> expenses);

    List<Transaction> settleUpExpenseUsers(List<ExpenseUser> expenseUsers);
}
