package com.shann.splitwise.repositories;

import com.shann.splitwise.entities.ExpenseUser;
import com.shann.splitwise.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseUserRepository extends JpaRepository<ExpenseUser, Integer> {
    List<ExpenseUser> findAllByUser(User user);

}
