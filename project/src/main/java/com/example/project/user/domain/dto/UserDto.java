package com.example.project.user.domain.dto;

import com.example.project.user.domain.entity.Email;
import com.example.project.user.domain.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class AddReq {
        String username;
        String password;
        String nickname;
        String bio;
        String email;

        @Builder
        public AddReq(String username, String password, String nickname, String bio, String email) {
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
    public static class UpdateReq {
        String nickname;
        String bio;

        @Builder
        public UpdateReq(String nickname, String bio) {
            this.nickname = nickname;
            this.bio = bio;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Res {
        String username;
        String nickname;
        String bio;
        String email;

        public Res(final User user) {
            this.username = user.getUsername();
            this.nickname = user.getNickname();
            this.bio = user.getBio();
            this.email = user.getEmail().getValue();
        }
    }
}
