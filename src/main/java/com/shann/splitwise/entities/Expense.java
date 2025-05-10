package com.shann.splitwise.entities;

import com.shann.splitwise.enums.ExpenseType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Expense extends BaseModel {
    private String name;
    private String description;
    private Double amount;
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;
    @OneToMany(mappedBy = "expense", fetch = FetchType.EAGER)
    private List<ExpenseUser> expenseUsers;
    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;
    @ManyToOne
    @JoinColumn(name = "added_by", referencedColumnName = "id")
    private User addedBy;

}
