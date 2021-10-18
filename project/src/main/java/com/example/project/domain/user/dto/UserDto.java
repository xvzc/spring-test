package com.example.project.domain.user.dto;

import com.example.project.domain.user.entity.User;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UserDto {

    @Getter
    @Builder
    @EqualsAndHashCode
    public static class AddRequest {
        private String username;
        @Size(min = 6, max = 20)
        private String password;
        private String nickname;
        private String bio;
        @Email
        private String email;

        public User toEntity() {
            return User.builder()
                    .username(username)
                    .password(password)
                    .nickname(nickname)
                    .bio(bio)
                    .email(email)
                    .build();
        }
    }

    @Getter
    @Builder
    @EqualsAndHashCode
    public static class UpdateRequest {
        private String nickname;
        private String bio;
    }

    @Getter
    @Builder
    @EqualsAndHashCode
    public static class Response {
        private Long idx;
        private String username;
        private String nickname;
        private String bio;
        private String email;

        public static Response of(final User user) {
            return Response.builder()
                    .idx(user.getId())
                    .username(user.getUsername())
                    .nickname(user.getNickname())
                    .bio(user.getBio())
                    .email(user.getEmail().getValue())
                    .build();
        }
    }
}
