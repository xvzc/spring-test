package com.example.project.user.web.controller;

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
    public ResponseEntity<UserDto.Response> getUser(@PathVariable final Long id) {
        return ResponseEntity.ok()
                .body(userService.getUser(id));
    }

    @GetMapping("")
    public ResponseEntity<List<UserDto.Response>> getUserList(@RequestParam(value = "user_id", required = false) String userId) {
        return ResponseEntity.ok()
                .body(userService.getUserList());
    }


    @PostMapping("")
    public ResponseEntity<UserDto.Response> addUser(@RequestBody final UserDto.AddRequest dto) {
        return ResponseEntity.ok()
                .body(userService.addUser(dto)) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto.Response> updateUser(@RequestBody final UserDto.UpdateRequest dto, @PathVariable final Long id) {
        return ResponseEntity.ok()
                .body(userService.updateUser(dto, id));
    }
}