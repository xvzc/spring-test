package com.example.project.user.domain.dto.user;

import lombok.*;

@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class UserAddResponseDTO {
    String username;
    String password;
    String nickname;
    String bio;
    String email;
}
