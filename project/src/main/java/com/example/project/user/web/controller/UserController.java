package com.example.project.user.web.controller;

import com.example.project.user.domain.dto.user.UserAddResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

//    @PostMapping("/users")
//    public ResponseEntity<UserAddResponseDTO> addUser(@RequestBody UserAddRequestDTO requestDTO) {
//        return new ResponseEntity<UserAddResponseDTO>().Ok().body();
//    }
}
