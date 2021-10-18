package com.example.project.global.dto;

import com.example.project.global.error.BasicError;
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