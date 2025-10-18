package com.tau.todoapp.repository;

import com.tau.todoapp.model.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class TodoRepositoryTest {

    @Autowired
    private TodoRepository repository;

    @Test
    void shouldFindByCompletedStatus() {
        repository.save(new Todo("Task 1", true, LocalDate.now()));
        repository.save(new Todo("Task 2", false, LocalDate.now()));

        List<Todo> completed = repository.findByCompleted(true);
        assertThat(completed).hasSize(1);
        assertThat(completed.getFirst().getTitle()).isEqualTo("Task 1");
    }
}
