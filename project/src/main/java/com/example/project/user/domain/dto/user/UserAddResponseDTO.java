package com.example.project.user.domain.dto.user;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class UserAddResponseDTO {
    String username;
    String nickname;
    String bio;
    String email;
}
