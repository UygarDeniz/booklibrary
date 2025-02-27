package com.uygardeniz.exceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity<ApiError> handleValidationErrors(MethodArgumentNotValidException e) {
        Map <String, List<String>> errors = new HashMap<>();
        
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            if(errors.containsKey(fieldName)) {
                errors.get(fieldName).add(errorMessage);
            } else {
                List<String> messages = new ArrayList<>();
                messages.add(errorMessage);
                errors.put(fieldName, messages);
            }
        });
    
        ApiError apiError = new ApiError(
            HttpStatus.BAD_REQUEST.value(),
            "Validation error",
            errors
        );

        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ApiError apiError = new ApiError(
            HttpStatus.NOT_FOUND.value(),
            "Resource not found",
            List.of(ex.getMessage())
        );

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGeneralExceptions(Exception ex) {
        ApiError apiError = new ApiError(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Internal server error",
            List.of(ex.getMessage())
        );

        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
