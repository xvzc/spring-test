package com.example.project._global.dto;

import com.example.project._global.error.BasicError;
import lombok.*;

@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CheckResponse {
    Boolean success;
    BasicError error;

    public static CheckResponse of(Boolean success) {
        return CheckResponse.builder()
                .success(success)
                .build();
    }
}