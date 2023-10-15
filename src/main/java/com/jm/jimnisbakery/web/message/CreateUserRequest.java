package com.jm.jimnisbakery.web.message;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String name;
    private String loginToken;
    private String email;
    private String snsId;
    private String phoneNumber;
    private String address;
}
