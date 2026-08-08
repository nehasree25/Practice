package com.example.todo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.todo.dto.TodoDto;
import com.example.todo.service.ITodoService;


@RestController
@AllArgsConstructor
public class TodoController {
    ITodoService todoService;
    @PostMapping("create/")
    public ResponseEntity<String> postMethodName(@RequestBody TodoDto todoDto) {
        todoService.createTodo(todoDto);
        
        return ResponseEntity.ok("Todo created successfully");
    }
    
}
