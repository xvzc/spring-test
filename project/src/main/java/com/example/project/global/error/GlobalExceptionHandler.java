package com.example.project.global.error;

import com.example.project.global.error.exception.AlreadyExistsException;
import com.example.project.global.error.exception.ResourceNotFoundException;
import com.example.project.global.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.nio.file.AccessDeniedException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /** Custom Exceptions START */

    // 자원을 찾을 수 없는 경우
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ResourceNotFoundException.class)
    protected ErrorResponse handleResourceNotFoundException(ResourceNotFoundException e) {
        log.error("handleMethodArgumentNotValidException", e);
        return ErrorResponse.of(BasicError.of(e.errorCode));
    }

    // Unique
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AlreadyExistsException.class)
    protected ErrorResponse handleAlreadyExistsException(AlreadyExistsException e) {
        log.error("handleAlreadyExistsException", e);
        return ErrorResponse.of(BasicError.of(e.errorCode));
    }

    /** Custom Exceptions END*/


    /** Built in Exceptions START */

    // Bean Validation 실패
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("handleMethodArgumentNotValidException", e);
        return ErrorResponse.of(BasicError.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult()));
    }

    // 데이터베이스 무결성
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ErrorResponse handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        log.error("handleMethodArgumentNotValidException", e);
        return ErrorResponse.of(BasicError.of(ErrorCode.INVALID_INPUT_VALUE));
    }

    // 데이터베이스 무결성
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    protected ErrorResponse handleConstraintViolationException(ConstraintViolationException e) {
        log.error("handlerConstraintViolationException", e);
        return ErrorResponse.of(BasicError.of(ErrorCode.INVALID_INPUT_VALUE));
    }

    // 지원하지 않는 HTTP Method
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ErrorResponse handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("handleHttpRequestMethodNotSupportedException", e);
        return ErrorResponse.of(BasicError.of(ErrorCode.METHOD_NOT_ALLOWED));
    }

    // Authentication 객체가 필요한 권한을 보유하지 않은 경우 발생합
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AccessDeniedException.class)
    protected ErrorResponse handleAccessDeniedException(AccessDeniedException e) {
        log.error("handleAccessDeniedException", e);
        return ErrorResponse.of(BasicError.of(ErrorCode.ACCESS_DENIED));
    }

    // 나머지 모든 예외들
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    protected ErrorResponse handleException(Exception e) {
        log.error("handleEntityNotFoundException", e);
        return ErrorResponse.of(BasicError.of(ErrorCode.INTERNAL_SERVER_ERROR));
    }

    /** Built in Exceptions END */
}