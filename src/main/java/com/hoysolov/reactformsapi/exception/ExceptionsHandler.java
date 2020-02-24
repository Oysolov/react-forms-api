package com.hoysolov.reactformsapi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(AppException.class)
    public ResponseEntity handleAppException(AppException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
