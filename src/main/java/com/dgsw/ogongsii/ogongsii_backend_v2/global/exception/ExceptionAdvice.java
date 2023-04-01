package com.dgsw.ogongsii.ogongsii_backend_v2.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ExceptionResponse> CommonException(BusinessException e) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .status(e.getStatus().value())
                .error(e.getStatus())
                .message(e.getMessage())
                .build();
        return ResponseEntity.status(e.getStatus())
                .body(exceptionResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ExceptionResponse> MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST)
                .message(e.getBindingResult().getAllErrors().get(0).getDefaultMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(exceptionResponse);
    }
}
