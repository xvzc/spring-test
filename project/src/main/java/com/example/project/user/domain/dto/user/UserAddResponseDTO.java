package com.example.project.user.domain.dto.user;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserAddResponseDTO {
    String username;
    String password;
    String nickname;
    String bio;
    String email;
}
