package com.example.project._global.dto;

import com.example.project._global.error.BasicError;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SingleResponse<T> {
    T data;
    BasicError error = null;

    public static <T> SingleResponse<T> of(T data) {
        return SingleResponse.<T>builder()
                .data(data)
                .build();
    }
}
