package com.shann.splitwise.command;

public interface Command {

    void execute(String command);

    boolean match(String command);
}
