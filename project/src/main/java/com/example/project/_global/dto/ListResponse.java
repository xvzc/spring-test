package com.example.project._global.dto;

import com.example.project._global.error.BasicError;
import lombok.*;

import java.util.List;


@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ListResponse<T> {
    List<T> data;
    BasicError error;

    public static <T> ListResponse<T> of(List<T> data) {
        return ListResponse.<T>builder()
                .data(data)
                .build();
    }
}