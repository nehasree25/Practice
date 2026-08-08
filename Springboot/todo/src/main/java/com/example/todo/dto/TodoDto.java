package com.example.todo.dto;

import lombok.AllArgsConstructor;
import lombok.*;

@AllArgsConstructor @Data @NoArgsConstructor
public class TodoDto {
    private String title;
    private String description;
}
