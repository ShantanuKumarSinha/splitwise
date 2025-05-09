package com.shann.splitwise.repositories;

import com.shann.splitwise.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository  extends JpaRepository<Group, Integer> {
}
