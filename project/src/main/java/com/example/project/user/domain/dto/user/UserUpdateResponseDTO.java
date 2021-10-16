package com.example.project.user.domain.dto.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class UserUpdateResponseDTO {
    String nickname;
    String bio;
}
