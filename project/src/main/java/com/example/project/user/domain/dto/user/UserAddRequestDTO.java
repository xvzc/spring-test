package com.example.project.user.domain.dto.user;

import lombok.*;

@Getter
public class UserAddRequestDTO {
    private String username;
    private String password;
    private String nickname;
    private String bio;
    private String email;
}
