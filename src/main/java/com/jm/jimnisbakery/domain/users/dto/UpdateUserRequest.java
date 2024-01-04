package com.jm.jimnisbakery.domain.users.dto;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private Long userId;
    private String name;
    private String loginToken;
    private String email;
    private String snsId;
    private String phoneNumber;
    private String address;
}
