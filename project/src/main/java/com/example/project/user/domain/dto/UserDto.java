package com.example.project.user.domain.dto;

import com.example.project.user.domain.entity.Email;
import com.example.project.user.domain.entity.User;
import lombok.*;

public class UserDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @EqualsAndHashCode
    public static class AddRequest {
        String username;
        String password;
        String nickname;
        String bio;
        String email;

        @Builder
        public AddRequest(String username, String password, String nickname, String bio, String email) {
            this.username = username;
            this.password = password;
            this.nickname = nickname;
            this.bio = bio;
            this.email = email;
        }

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
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @EqualsAndHashCode
    public static class UpdateRequest {
        String nickname;
        String bio;

        @Builder
        public UpdateRequest(String nickname, String bio) {
            this.nickname = nickname;
            this.bio = bio;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @EqualsAndHashCode
    public static class Response {
        String username;
        String nickname;
        String bio;
        String email;

        public Response(final User user) {
            this.username = user.getUsername();
            this.nickname = user.getNickname();
            this.bio = user.getBio();
            this.email = user.getEmail().getValue();
        }
    }
}
