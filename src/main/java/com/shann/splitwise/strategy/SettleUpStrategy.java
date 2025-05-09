package com.shann.splitwise.strategy;

import com.shann.splitwise.models.Transaction;

import java.util.List;

public interface SettleUpStrategy {

    List<Transaction> settleUp(List<Transaction> transactions);
}
