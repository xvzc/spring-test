package com.example.project._global.response;

import com.example.project._global.error.BasicError;
import lombok.*;

import java.util.List;


@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ListResponse<T> extends CommonResponse {
    List<T> data;
    BasicError error;

    public static <T> ListResponse<T> of(List<T> data) {
        return ListResponse.<T>builder()
                .data(data)
                .build();
    }
}