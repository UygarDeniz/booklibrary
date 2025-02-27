package com.uygardeniz.exceptions;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class ApiError {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private Map<String, List<String>> validationErrors;
    private List<String> errors;

    // For validation errors
    public ApiError(int status, String message, Map<String, List<String>> validationErrors) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
        this.validationErrors = validationErrors;
    }

    // For general errors
    public ApiError(int status, String message, List<String> errors) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, List<String>> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(Map<String, List<String>> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    
}