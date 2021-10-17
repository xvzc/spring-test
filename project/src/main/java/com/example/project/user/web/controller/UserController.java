package com.example.project.user.web.controller;

import com.example.project._global.response.ListResponse;
import com.example.project._global.response.SingleResponse;
import com.example.project.user.domain.dto.UserDto;
import com.example.project.user.web.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;

    @GetMapping("{id}")
    public SingleResponse getUser(@PathVariable final Long id) {
        return userService.getUser(id);
    }

    @GetMapping("")
    public ListResponse getUserList(@RequestParam(value = "user_id", required = false) String userId) {
        return userService.getUserList();
    }

    @PostMapping("")
    public SingleResponse addUser(@RequestBody final UserDto.AddRequest dto) {
        return userService.addUser(dto);
    }

    @PutMapping("/{id}")
    public SingleResponse updateUser(@RequestBody final UserDto.UpdateRequest dto, @PathVariable final Long id) {
        return userService.updateUser(dto, id);
    }
}