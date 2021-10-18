package com.example.project.global.dto;

import com.example.project.global.error.BasicError;
import lombok.*;

@Getter
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CheckResponse {
    Boolean success;
    BasicError error;

    public static CheckResponse of(Boolean success) {
        return new CheckResponse(success, null);
    }
}