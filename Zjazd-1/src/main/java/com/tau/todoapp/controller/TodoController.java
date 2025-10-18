package com.tau.todoapp.controller;

import com.tau.todoapp.model.Todo;
import com.tau.todoapp.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getAll() {
        return todoService.getAllTodos();
    }

    @PostMapping
    public Todo add(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }
}
