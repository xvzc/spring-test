package com.example.project._global.exception.user;

public class AgeTooYoungException extends RuntimeException {
    public AgeTooYoungException() {
        super("나이가 너무 어려요 ...");
    }
}
