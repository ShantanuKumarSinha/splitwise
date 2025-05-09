package com.shann.splitwise.command.executor;

import com.shann.splitwise.command.Command;

import java.util.List;

public class CommandExecutor {
    private List<Command> commands;

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void execute(String command) {
        commands.stream().filter(c -> c.match(command)).findFirst().ifPresent(c -> c.execute(command));
    }
}
