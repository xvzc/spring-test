package com.example.project._global.error.exception;

import com.example.project._global.error.ErrorCode;

public class AlreadyExistsException extends RuntimeException {
    public ErrorCode errorCode;
    public AlreadyExistsException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
