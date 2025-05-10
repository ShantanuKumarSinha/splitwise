package com.shann.splitwise.command.impl;

import com.shann.splitwise.command.Command;
import com.shann.splitwise.command.utils.CommandKeyWords;
import com.shann.splitwise.controller.SettleUpController;
import com.shann.splitwise.dtos.SettleUpUserRequestDto;

public class SettleUpCommand implements Command {

    private SettleUpController settleUpController;

    public SettleUpCommand(SettleUpController settleUpController) {
        this.settleUpController = settleUpController;
    }

    @Override
    public void execute(String command) {
        var words = command.split(" ");
        var userId = words[0];
        // create SettleUpUserRequest Dto
        var settleUpUserRequestDto = new SettleUpUserRequestDto();
        settleUpUserRequestDto.setUserId(Integer.parseInt(userId));
        // Call the UserController to settle up the user
        var settleUpUserResponseDto = settleUpController.settleUpUser(settleUpUserRequestDto);

    }

    @Override
    public boolean match(String command) {
        var words = command.split(" ");
        return words.length == 2 && words[1].equalsIgnoreCase(CommandKeyWords.SettleUpUserCommand);
    }
}
