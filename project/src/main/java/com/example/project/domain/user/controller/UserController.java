package com.example.project.domain.user.controller;

import com.example.project.global.dto.ListResponse;
import com.example.project.global.dto.UnitResponse;
import com.example.project.domain.user.dto.UserDto;
import com.example.project.domain.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
}