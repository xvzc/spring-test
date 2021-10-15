package com.example.project._global.exception.user;

import com.example.project.user.domain.entity.User;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException() {
        super("이미 존재하는 유저입니다.");
    }
}
