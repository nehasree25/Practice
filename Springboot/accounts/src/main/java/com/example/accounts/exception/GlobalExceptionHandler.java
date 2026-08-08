package com.example.accounts.exception;

import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.accounts.dto.ErrorResponeDto;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomerAlreadyExistsMobileNumber.class)
    public ResponseEntity<ErrorResponeDto> handleCustomerAlreadyExistsMobileNumber(CustomerAlreadyExistsMobileNumber ex, WebRequest request) {
        
        ErrorResponeDto errorResponse = new ErrorResponeDto(
            request.getDescription(false),
            HttpStatus.BAD_REQUEST,
            ex.getMessage(),
            LocalTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
