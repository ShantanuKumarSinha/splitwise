package com.shann.splitwise.strategy.impl;

import com.shann.splitwise.models.Transaction;
import com.shann.splitwise.strategy.SettleUpStrategy;

import java.util.List;

public class HeapSettleUpStrategy implements SettleUpStrategy {
    /**
     *
     * @param transactions
     * @return
     */
    @Override
    public List<Transaction> settleUp(List<Transaction> transactions) {
        return List.of();
    }
}
