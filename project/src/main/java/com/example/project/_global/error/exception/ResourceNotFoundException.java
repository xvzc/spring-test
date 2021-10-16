package com.example.project._global.error.exception;

import com.example.project._global.error.ErrorCode;

public class ResourceNotFoundException  extends RuntimeException {
    public ErrorCode errorCode;

    public ResourceNotFoundException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}