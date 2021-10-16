package com.example.project._global.error;

import com.example.project._global.error.exception.AlreadyExistsException;
import com.example.project._global.error.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /** Custom Exceptions START */

    // 자원을 찾을 수 없는 경우
    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException e) {
        log.error("handleMethodArgumentNotValidException", e);
        return ResponseEntity.badRequest().body(ErrorResponse.of(e.errorCode));
    }

    // Unique
    @ExceptionHandler(AlreadyExistsException.class)
    protected ResponseEntity<ErrorResponse> handleAlreadyExistsException(AlreadyExistsException e) {
        log.error("handleAlreadyExistsException", e);
        return ResponseEntity.badRequest().body(ErrorResponse.of(e.errorCode));
    }

    /** Custom Exceptions END*/


    /** Built in Exceptions START */

    // Bean Validation 실패
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("handleMethodArgumentNotValidException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // Bean Validation 실패
    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        log.error("handleMethodArgumentNotValidException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // 지원하지 않는 HTTP Method
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("handleHttpRequestMethodNotSupportedException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.METHOD_NOT_ALLOWED);
        return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
    }

    // Authentication 객체가 필요한 권한을 보유하지 않은 경우 발생합
    @ExceptionHandler(AccessDeniedException.class)
    protected ResponseEntity<ErrorResponse> handleAccessDeniedException(AccessDeniedException e) {
        log.error("handleAccessDeniedException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.ACCESS_DENIED);
        return new ResponseEntity<>(response, HttpStatus.valueOf(ErrorCode.ACCESS_DENIED.getStatus()));
    }

    // 나머지 모든 예외들
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error("handleEntityNotFoundException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /** Built in Exceptions END */
}