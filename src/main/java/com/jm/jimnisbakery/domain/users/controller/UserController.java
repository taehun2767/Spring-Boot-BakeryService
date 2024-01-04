package com.jm.jimnisbakery.domain.users.controller;

import com.jm.jimnisbakery.global.common.ApiResult;
import com.jm.jimnisbakery.global.common.JRoute;
import com.jm.jimnisbakery.domain.users.service.UserService;
import com.jm.jimnisbakery.domain.users.dto.UserDto;
import com.jm.jimnisbakery.domain.users.dto.CreateUserRequest;
import com.jm.jimnisbakery.domain.users.dto.UpdateUserRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(value = JRoute.API_USERS)
    public ApiResult<UserDto> CreateUser(@RequestBody CreateUserRequest req){
        return userService.createUser(req);
    }

    @GetMapping(value = JRoute.API_USER_DETAILS)
    public ApiResult<UserDto> GetUserDetails(@RequestParam Long userId){
        return userService.getUserDetails(userId);
    }

    @PutMapping(value = JRoute.API_USERS)
    public ApiResult<UserDto> UpdateUser(@RequestBody UpdateUserRequest req){
        return userService.updateUser(req);
    }

    @DeleteMapping(value = JRoute.API_USERS)
    public ApiResult DeleteUser(@RequestParam Long userId){
        int status = userService.deleteUser(userId);
        return new ApiResult(status);
    }
}
