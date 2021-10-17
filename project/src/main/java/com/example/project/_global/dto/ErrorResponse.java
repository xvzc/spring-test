package com.example.project._global.dto;

import com.example.project._global.error.BasicError;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {
    Object data = null;
    BasicError error;

    public static ErrorResponse of(BasicError error) {
        return ErrorResponse.builder()
                .error(error)
                .build();
    }
}