package com.shann.splitwise.entities;

import com.shann.splitwise.enums.UserType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "splitwise_user")
@Data
public class User extends BaseModel {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    @Enumerated(EnumType.ORDINAL)
    private UserType userType;
    @ManyToMany(mappedBy = "members")
    private List<Group> group;
}
