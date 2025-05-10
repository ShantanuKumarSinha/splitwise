package com.shann.splitwise.services;


import com.shann.splitwise.exceptions.GroupNotFoundException;
import com.shann.splitwise.exceptions.UserNotFoundException;
import com.shann.splitwise.models.Transaction;

import java.util.List;

public interface SettleUpService {
    public List<Transaction> settleUpGroup(Integer groupId) throws GroupNotFoundException;

    public List<Transaction> settleUpUser(Integer userId) throws UserNotFoundException;
}
