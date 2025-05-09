package com.shann.splitwise.command.impl;

import com.shann.splitwise.command.Command;

public class RegisterCommand implements Command {
    @Override
    public void execute(String command) {

    }

    @Override
    public boolean match(String command) {
        String[] words = command.split(" ");
        return words[0].equalsIgnoreCase("register");
    }
}
