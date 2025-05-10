package com.shann.splitwise.exceptions;

public class GroupNotFoundException extends Exception {
    public GroupNotFoundException() {
        super("Group not found");
    }

    public GroupNotFoundException(String message) {
        super(message);
    }
}
