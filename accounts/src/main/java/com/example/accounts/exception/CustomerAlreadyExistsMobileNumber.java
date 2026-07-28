package com.example.accounts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomerAlreadyExistsMobileNumber extends RuntimeException{
    public CustomerAlreadyExistsMobileNumber(String message) {
        super(message);
    }
}
