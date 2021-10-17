package com.example.project._global.dto;

import com.example.project._global.error.BasicError;
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
