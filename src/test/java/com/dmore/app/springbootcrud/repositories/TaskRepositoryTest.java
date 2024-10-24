package com.dmore.app.springbootcrud.repositories;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.dmore.app.springbootcrud.entities.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
public class TaskRepositoryTest {
    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void getAllTask() {
        List<Task> tasks = taskRepository.findAll();
        assertTrue(!tasks.isEmpty());
    }


}

