package com.example.project._global.dto;

import com.example.project._global.error.BasicError;
import lombok.*;

@Getter
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {
    Object data;
    BasicError error;

    public static ErrorResponse of(BasicError error) {
        return new ErrorResponse(null, error);
    }
}