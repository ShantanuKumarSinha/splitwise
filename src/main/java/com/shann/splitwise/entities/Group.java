package com.shann.splitwise.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "splitwise_group")
@Data
public class Group extends BaseModel{
    private String name;
    @ManyToMany
    @JoinTable(
            name = "group_members",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> members;
    @ManyToOne
    private User admin;
    @OneToMany(mappedBy = "group")
    private List<Expense> expenses;
}
