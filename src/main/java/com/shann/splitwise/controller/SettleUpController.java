package com.shann.splitwise.controller;


import com.shann.splitwise.dtos.*;
import com.shann.splitwise.services.SettleUpService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Settle up controller.
 */
@RestController
@RequestMapping("/settleUp")
public class SettleUpController {

    private SettleUpService settleUpService;

    public SettleUpController(SettleUpService settleUpService) {
        this.settleUpService = settleUpService;
    }

    /**
     * Settle up the group.
     *
     * @param requestDTO the request dto
     * @return the settle up group response dto
     */
    @PostMapping("/group")
    public SettleUpGroupResponseDto settleUpGroup(@RequestBody SettleUpGroupRequestDTO requestDTO) {
        var responseDto = new SettleUpGroupResponseDto();
        try {
            var transactions = settleUpService.settleUpGroup(requestDTO.getGroupId());
            responseDto.setTransactions(transactions);
            responseDto.setResponseStatus(ResponseStatusDto.SUCCESS);
            return responseDto;
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatusDto.FAILURE);
        }
        return responseDto;
    }

    /**
     * Settle up the user.
     *
     * @param requestDTO having the user id
     * @return the settle up user response dto
     */
    @PostMapping("/user")
    public SettleUpUserResponseDto settleUpUser(@RequestBody SettleUpUserRequestDTO requestDTO) {
        var responseDto = new SettleUpUserResponseDto();
        try {
            var transactions = settleUpService.settleUpUser(requestDTO.getUserId());
            responseDto.setTransactions(transactions);
            responseDto.setResponseStatus(ResponseStatusDto.SUCCESS);
            return responseDto;
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatusDto.FAILURE);
        }
        return responseDto;
    }
}
