package com.shann.splitwise.command.impl;

import com.shann.splitwise.command.Command;
import com.shann.splitwise.command.utils.CommandKeyWords;

import java.util.List;

public class RegisterCommand implements Command {
    @Override
    public void execute(String command) {
        var words = List.of(command.split(" "));
        var name = words.get(1);
        var email = words.get(2);
        var phoneNumber = words.get(3);
        // create UserRequest Dto and set the values in that and call UserController to register the user

    }

    @Override
    public boolean match(String command) {
        var words = List.of(command.split(" "));
        return words.size() == 4 && words.getFirst().equalsIgnoreCase(CommandKeyWords.RegisterCommand);
    }
}
