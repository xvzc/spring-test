package com.example.project._global.exception.user;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("유저가 존재하지 않습니다.");
    }
}