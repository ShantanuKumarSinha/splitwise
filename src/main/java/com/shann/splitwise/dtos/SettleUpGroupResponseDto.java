package com.shann.splitwise.dtos;

import com.shann.splitwise.models.Transaction;
import lombok.Data;

import java.util.List;

@Data
public class SettleUpGroupResponseDto {

    private List<Transaction>transactions;
    private ResponseStatusDto responseStatus;

}
