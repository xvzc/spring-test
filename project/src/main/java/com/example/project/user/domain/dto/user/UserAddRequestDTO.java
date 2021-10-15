package com.example.project.user.domain.dto.user;

import lombok.*;

@Getter
public class UserAddRequestDTO {
    String username;
    String password;
    String nickname;
    String bio;
    String email;
}
