package com.cust.customerproject.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.validation.ObjectError;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle Validation Exceptions
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {

        Map<String, String> errorMap = new HashMap<>();

        e.getBindingResult().getAllErrors().forEach((ObjectError error) -> {
            String fieldName = e.getFieldError().getField();
            String message = e.getFieldError().getDefaultMessage();
            errorMap.put(fieldName, message);
        });

        return errorMap;
    }

    // Handle Arithmetic Exception
    @ExceptionHandler(ArithmeticException.class)
    public String handleArithmeticException(ArithmeticException e) {
        return e.getMessage();
    }

    // Handle Null Pointer Exception
    @ExceptionHandler(NullPointerException.class)
    public String handleNullPointerException(NullPointerException e) {
        return e.getMessage();
    }

    // Handle Illegal Argument Exception
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(IllegalArgumentException e) {
        return e.getMessage();
    }

    // Handle Generic Exception
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        return e.getMessage();
    }
}