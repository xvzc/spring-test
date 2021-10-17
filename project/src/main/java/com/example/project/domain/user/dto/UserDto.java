package com.example.project.domain.user.dto;

import com.example.project.domain.user.entity.Email;
import com.example.project.domain.user.entity.User;
import lombok.*;

public class UserDto {

    @Getter
    @Builder
    @EqualsAndHashCode
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class AddRequest {
        private String username;
        private String password;
        private String nickname;
        private String bio;
        private String email;

        public User toEntity() {
            return User.builder()
                    .username(username)
                    .password(password)
                    .nickname(nickname)
                    .bio(bio)
                    .email(Email.of(email))
                    .build();
        }
    }

    @Getter
    @Builder
    @EqualsAndHashCode
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UpdateRequest {
        private String nickname;
        private String bio;

    }

    @Getter
    @Builder
    @EqualsAndHashCode
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {
        private String username;
        private String nickname;
        private String bio;
        private String email;

        public static Response of(final User user) {
            return Response.builder()
                    .username(user.getUsername())
                    .nickname(user.getNickname())
                    .bio(user.getBio())
                    .email(user.getEmail().getValue())
                    .build();
        }
    }
}
