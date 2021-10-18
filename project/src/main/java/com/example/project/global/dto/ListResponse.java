package com.example.project.global.dto;

import com.example.project.global.error.BasicError;
import lombok.*;

import java.util.List;


@Getter
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ListResponse<T> {
    List<T> data;
    BasicError error;

    public static <T> ListResponse<T> of(List<T> data) {
        return new ListResponse<>(data, null);
    }
}