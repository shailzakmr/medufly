package com.medufly.edu.config;

import com.medufly.edu.dto.LeadResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<LeadResponse> handleValidation(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors().stream()
                .map(e -> e.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return ResponseEntity.badRequest().body(LeadResponse.error(message));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<LeadResponse> handleGeneral(Exception ex) {
        return ResponseEntity.internalServerError()
                .body(LeadResponse.error("Something went wrong. Please try again."));
    }
}
