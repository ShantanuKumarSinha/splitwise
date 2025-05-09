package com.shann.splitwise.models;

import com.shann.splitwise.entities.User;
import lombok.Data;

@Data
public class Transaction {

    private User fromUser;
    private User toUser;
    private double amount;
}
