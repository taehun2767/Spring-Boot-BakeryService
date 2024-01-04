package com.jm.jimnisbakery.domain.users.controller;

import com.jm.jimnisbakery.domain.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JwtLoginApiController {
    private final UserService userService;

    @PostMapping()
    public String signUp(){}

    @PostMapping
    public String login(){}

}
