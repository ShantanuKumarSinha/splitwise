package com.shann.splitwise.entities;

import com.shann.splitwise.enums.ExpenseUserType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ExpenseUser extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    private double amount;
    private String currency;
    private double currencyRate;
    @Enumerated(EnumType.ORDINAL)
    private ExpenseUserType expenseUserType;
    @ManyToOne
    @JoinColumn(name = "expense_id", referencedColumnName = "id")
    private Expense expense;

}
