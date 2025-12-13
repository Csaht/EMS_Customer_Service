/*
package com.enterprise.ems.exceptions;


import com.enterprise.ems.dtos.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleException(Exception ex) {
        ApiResponse<String> response = new ApiResponse<>(
                false,
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Something went wrong: " + ex.getMessage(),
                null,
                null
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleResourceNotFound(ResourceNotFoundException ex) {
        ApiResponse<String> response = new ApiResponse<>(
                false,
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                null,
                null
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}

*/
package com.enterprise.ems.exceptions;

import com.enterprise.ems.dtos.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        // Collect all field validation messages
        String errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining("; "));

        ApiResponse<String> response = new ApiResponse<>(
                false,
                HttpStatus.BAD_REQUEST.value(),
                "Validation failed: " + errors,
                null,
                null
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleResourceNotFound(ResourceNotFoundException ex) {
        ApiResponse<String> response = new ApiResponse<>(
                false,
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                null,
                null
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleException(Exception ex) {
        ApiResponse<String> response = new ApiResponse<>(
                false,
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Something went wrong: " + ex.getMessage(),
                null,
                null
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
