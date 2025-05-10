package com.shann.splitwise.repositories;

import com.shann.splitwise.entities.Expense;
import com.shann.splitwise.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    List<Expense> findAllByGroup(Group group);

}
