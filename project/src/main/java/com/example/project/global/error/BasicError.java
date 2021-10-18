package com.example.project.global.error;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BasicError {

    private String message;
    private int status;
    private List<FieldError> fields;
    private String code;

    private BasicError(final ErrorCode code, final List<FieldError> fields) {
        this.message = code.getMessage();
        this.status = code.getStatus();
        this.fields = fields;
        this.code = code.getCode();
    }

    private BasicError(final ErrorCode code) {
        this.message = code.getMessage();
        this.status = code.getStatus();
        this.code = code.getCode();
        this.fields = new ArrayList<>();
    }


    public static BasicError of(final ErrorCode code, final BindingResult bindingResult) {
        return new BasicError(code, FieldError.of(bindingResult));
    }

    public static BasicError of(final ErrorCode code) {
        return new BasicError(code);
    }

    public static BasicError of(final ErrorCode code, final List<FieldError> errors) {
        return new BasicError(code, errors);
    }

    public static BasicError of(MethodArgumentTypeMismatchException e) {
        final String value = e.getValue() == null ? "" : e.getValue().toString();
        final List<BasicError.FieldError> errors = BasicError.FieldError.of(e.getName(), value, e.getErrorCode());
        return new BasicError(ErrorCode.INVALID_TYPE_VALUE, errors);
    }


    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class FieldError {
        private String field;
        private String value;
        private String reason;

        private FieldError(final String field, final String value, final String reason) {
            this.field = field;
            this.value = value;
            this.reason = reason;
        }

        public static List<FieldError> of(final String field, final String value, final String reason) {
            List<FieldError> fieldErrors = new ArrayList<>();
            fieldErrors.add(new FieldError(field, value, reason));
            return fieldErrors;
        }

        private static List<FieldError> of(final BindingResult bindingResult) {
            final List<org.springframework.validation.FieldError> fieldErrors = bindingResult.getFieldErrors();
            return fieldErrors.stream()
                    .map(error -> new FieldError(
                            error.getField(),
                            error.getRejectedValue() == null ? "" : error.getRejectedValue().toString(),
                            error.getDefaultMessage()))
                    .collect(Collectors.toList());
        }
    }
}