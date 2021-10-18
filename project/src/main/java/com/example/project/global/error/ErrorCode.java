package com.example.project.global.error;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    // GLOBAL
    INTERNAL_SERVER_ERROR(500, "G-000", "Server Error"),
    INVALID_INPUT_VALUE(400, "G-001", " Invalid Input Value"),
    METHOD_NOT_ALLOWED(405, "G-002", " Method not allowed"),
    INVALID_TYPE_VALUE(400, "G-003", " Invalid Type Value"),
    ACCESS_DENIED(403, "G-004", "Access is Denied"),

    // User
    EMAIL_DUPLICATION(400, "USER-001", "Email already exists"),
    LOGIN_FAILED(400, "USER-002", "Login failed"),
    USER_NOT_FOUND(400, "USER-003", "User not found"),
    USER_DUPLICATION(400, "USER-004", "User Already Exists")
    ; // 세미콜론 건드리지 마세요 ...

    private final String code;
    private final String message;
    private int status;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }
}