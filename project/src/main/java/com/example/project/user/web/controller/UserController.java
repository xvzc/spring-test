package com.example.project.user.web.controller;

import com.example.project.user.domain.dto.UserDto;
import com.example.project.user.domain.dto.user.UserAddRequestDTO;
import com.example.project.user.domain.dto.user.UserAddResponseDTO;
import com.example.project.user.domain.dto.user.UserUpdateRequestDTO;
import com.example.project.user.domain.dto.user.UserUpdateResponseDTO;
import com.example.project.user.web.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;

    @GetMapping("{id}")
    public ResponseEntity<UserDto.Res> getUser(@PathVariable final Long id) {
        return ResponseEntity.ok()
                .body(userService.getUser(id));
    }

    @GetMapping("")
    public ResponseEntity<List<UserDto.Res>> getUserList(@RequestParam(value = "user_id", required = false) String userId) {
        return ResponseEntity.ok()
                .body(userService.getUserList());
    }


    @PostMapping("")
    public ResponseEntity<UserDto.Res> addUser(@RequestBody final UserDto.AddReq dto) {
        return ResponseEntity.ok()
                .body(userService.addUser(dto)) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto.Res> updateUser(@RequestBody final UserDto.UpdateReq dto, @PathVariable final Long id) {
        return ResponseEntity.ok()
                .body(userService.updateUser(dto, id));
    }
}