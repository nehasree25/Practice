package com.example.todo.service.impl;

import org.springframework.stereotype.Service;

import com.example.todo.dto.TodoDto;
import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;
import com.example.todo.service.ITodoService;

import lombok.AllArgsConstructor;

import com.example.todo.mapper.TodoMapper;          
// import org.springframework.beans.factory.annotation.Autowired;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements ITodoService {
    private TodoRepository todoRepository;
    public void createTodo(TodoDto todoDto) {
        // Implementation for creating a todo
        TodoMapper todoMapper = new TodoMapper();
        Todo todo = todoMapper.mapToEntity(todoDto);
        todoRepository.save(todo);
    }

}
