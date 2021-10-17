package com.example.project._global.response;

import com.example.project._global.error.BasicError;
import com.example.project.user.domain.dto.UserDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse extends CommonResponse {
    Object data = null;
    BasicError error;

    public static ErrorResponse of(BasicError error) {
        return ErrorResponse.builder()
                .error(error)
                .build();
    }
}