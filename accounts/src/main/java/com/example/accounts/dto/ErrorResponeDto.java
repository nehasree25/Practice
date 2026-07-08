package com.example.accounts.dto;

import java.time.LocalTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data @AllArgsConstructor
public class ErrorResponeDto {
    private String apiPath;
    private HttpStatus errorCode;
    private String errorMessage;
    private LocalTime errorTime;
}
