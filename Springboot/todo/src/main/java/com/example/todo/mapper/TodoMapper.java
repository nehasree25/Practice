package com.example.todo.mapper;

import com.example.todo.dto.TodoDto;
import com.example.todo.entity.Todo;

import lombok.AllArgsConstructor;

public class TodoMapper {
    public Todo mapToEntity(TodoDto todoDto) {
        // Implementation for mapping TodoDto to Todo entity
        Todo todo = new Todo();
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        return todo;
    }
    public TodoDto mapToDto(Todo todo) {
        // Implementation for mapping Todo entity to TodoDto
        TodoDto todoDto = new TodoDto();
        todoDto.setTitle(todo.getTitle());
        todoDto.setDescription(todo.getDescription());
        return todoDto;
    }
}
