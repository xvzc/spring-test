package com.example.project.domain.user.controller;

import com.example.project._global.dto.ListResponse;
import com.example.project._global.dto.UnitResponse;
import com.example.project.domain.user.dto.UserDto;
import com.example.project.domain.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;

    @GetMapping("{id}")
    public UnitResponse<UserDto.Response> getUser(@PathVariable final Long id) {
        return UnitResponse.of(userService.getUser(id));
    }

    @GetMapping("")
    public ListResponse<UserDto.Response> getUserList() {
        return ListResponse.of(userService.getUserList());
    }

    @PostMapping("")
    public UnitResponse<UserDto.Response> addUser(@RequestBody final UserDto.AddRequest dto) {
        return UnitResponse.of(userService.addUser(dto));
    }

    @PutMapping("/{id}")
    public UnitResponse<UserDto.Response> updateUser(
            @RequestBody final UserDto.UpdateRequest dto,
            @PathVariable final Long id
    ) {
        return UnitResponse.of(userService.updateUser(dto, id));
    }
}