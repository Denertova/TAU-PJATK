package com.tau.todoapp.service;

import com.tau.todoapp.model.Todo;
import com.tau.todoapp.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @Test
    void shouldReturnAllTodos() {
        when(todoRepository.findAll()).thenReturn(List.of(new Todo("Test", false, LocalDate.now())));
        assertEquals(1, todoService.getAllTodos().size());
    }

    @Test
    void shouldFindTodoById() {
        Todo todo = new Todo("Buy milk", false, LocalDate.now());
        when(todoRepository.findById(1L)).thenReturn(Optional.of(todo));

        Optional<Todo> result = todoService.getTodoById(1L);
        assertTrue(result.isPresent());
        assertEquals("Buy milk", result.get().getTitle());
    }

    @Test
    void shouldSaveTodo() {
        Todo todo = new Todo("Learn Java", false, LocalDate.now());
        when(todoRepository.save(any())).thenReturn(todo);

        Todo saved = todoService.createTodo(todo);
        assertNotNull(saved);
        assertSame(todo, saved);
    }

    @Test
    void shouldDeleteTodoById() {
        doNothing().when(todoRepository).deleteById(1L);
        todoService.deleteTodo(1L);
        verify(todoRepository, times(1)).deleteById(1L);
    }

    @Test
    void shouldReturnCompletedTodos() {
        when(todoRepository.findByCompleted(true)).thenReturn(List.of(new Todo("Done", true, LocalDate.now())));
        assertFalse(todoService.getCompletedTodos().isEmpty());
    }
}
