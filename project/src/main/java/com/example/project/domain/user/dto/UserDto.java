package com.example.project.domain.user.dto;

import com.example.project.domain.user.entity.User;
import com.example.project.domain.user.entity.column.Role;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UserDto {
    @Getter
    @Builder
    @EqualsAndHashCode
    public static class AddRequest {
        @Email
        private String email;
        @Size(min = 6, max = 20)
        private Role role;

        public User toEntity() {
            return User.builder()
                    .email(email)
                    .role(role)
                    .build();
        }
    }

    @Getter
    @Builder
    @EqualsAndHashCode
    public static class Response {
        private Long id;
        private String email;
        private Role role;

        public static Response of(final User user) {
            return Response.builder()
                    .id(user.getId())
                    .email(user.getEmail())
                    .role(user.getRole())
                    .build();
        }
    }
}