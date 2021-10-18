package com.example.project.global.error.exception;

import com.example.project.global.error.ErrorCode;

public class AlreadyExistsException extends RuntimeException {
    public ErrorCode errorCode;
    public AlreadyExistsException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
