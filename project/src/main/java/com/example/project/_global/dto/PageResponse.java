package com.example.project._global.dto;

import com.example.project._global.error.BasicError;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class PageResponse<T> {
    Page<T> data;
    BasicError error = null;

    public static <T> PageResponse<T> of(Page<T> data) {
        return PageResponse.<T>builder()
                .data(data)
                .build();
    }
}
