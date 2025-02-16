package com.example.task_manager.repository;

import com.example.task_manager.model.Status;
import com.example.task_manager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findById(Long id);
    List<Task> findByStatus(Status status);
}
