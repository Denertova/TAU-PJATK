package com.tau.todoapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private boolean completed;
    private LocalDate dueDate;

    public Todo() {}

    public Todo(String title, boolean completed, LocalDate dueDate) {
        this.title = title;
        this.completed = completed;
        this.dueDate = dueDate;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public boolean isCompleted() { return completed; }
    public LocalDate getDueDate() { return dueDate; }

    public void setTitle(String title) { this.title = title; }
    public void setCompleted(boolean completed) { this.completed = completed; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
}
