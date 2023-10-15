package com.jm.jimnisbakery.web.controller;

import com.jm.jimnisbakery.common.ApiResult;
import com.jm.jimnisbakery.common.JRoute;
import com.jm.jimnisbakery.service.UserService;
import com.jm.jimnisbakery.web.dto.UserDto;
import com.jm.jimnisbakery.web.message.CreateUserRequest;
import com.jm.jimnisbakery.web.message.UpdateUserRequest;
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
