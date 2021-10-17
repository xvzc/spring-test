package com.example.project._global.dto;

import com.example.project._global.error.BasicError;
import lombok.*;
import org.springframework.data.domain.Page;

@Getter
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class PageResponse<T> {
    Page<T> data;
    BasicError error;

    public static <T> PageResponse<T> of(Page<T> data) {
        return new PageResponse<>(data, null);
    }
}
