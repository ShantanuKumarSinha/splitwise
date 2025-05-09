package com.shann.splitwise.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class User extends BaseModel {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String profilePictureUrl;
    private String address;
    private String dateOfBirth;
    @ManyToMany
    private List<Group> group;
}
