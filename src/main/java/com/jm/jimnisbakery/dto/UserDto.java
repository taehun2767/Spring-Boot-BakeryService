package com.jm.jimnisbakery.dto;


import com.jm.jimnisbakery.domain.users.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class UserDto {
    public String userHashId;
    public String name;
    public String loginToken;
    public String email;
    public String snsId;
    public String phoneNumber;
    public String address;

    public UserDto(String userHashId, String name, String loginToken, String email, String snsId, String phoneNumber, String address){
        this.userHashId = userHashId;
        this.name = name;
        this.loginToken = loginToken;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public UserDto(User user){
        userHashId = User.EncodeId(user.getId());
        name = user.getName();
        loginToken = user.getLoginToken();
        email = user.getEmail();
        snsId = user.getSnsId();
        phoneNumber = user.getPhoneNumber();
        address = user.getAddress();
    }
}
