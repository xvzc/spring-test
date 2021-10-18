package com.example.project.global.dto;

import com.example.project.global.error.BasicError;
import lombok.*;

@Getter
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class UnitResponse<T> {
    T data;
    BasicError error;

    public static <T> UnitResponse<T> of(T data) {
        return new UnitResponse<>(data, null);
    }
}
