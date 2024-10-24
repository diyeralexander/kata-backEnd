package com.dmore.app.springbootcrud.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dmore.app.springbootcrud.entities.Task;
import com.dmore.app.springbootcrud.repositories.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindAll() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task());
        when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> result = taskService.findAll();
        assertEquals(1, result.size());
    }

    @Test
    void testFindById() {
        Task task = new Task();
        task.setId(1L);
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        Optional<Task> result = taskService.findById(1L);
        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
    }

    @Test
    void testSave() {
        Task task = new Task();
        when(taskRepository.save(any(Task.class))).thenReturn(task);

        Task result = taskService.save(task);
        assertEquals(task, result);
    }

    @Test
    void testDeleteById() {
        doNothing().when(taskRepository).deleteById(1L);

        taskService.deleteById(1L);
        verify(taskRepository, times(1)).deleteById(1L);
    }
}