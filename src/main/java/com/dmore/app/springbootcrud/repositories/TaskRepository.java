package com.dmore.app.springbootcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmore.app.springbootcrud.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}