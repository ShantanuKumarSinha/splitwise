package com.shann.splitwise.models;

import com.shann.splitwise.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionPair {
    private User user;
    private double amount;


}
