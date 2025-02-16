package com.example.task_manager.service;

import com.example.task_manager.model.Status;
import com.example.task_manager.model.Task;
import com.example.task_manager.repository.TaskRepository;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    
    private final Timer myTimer;
    
    private final Counter myCounter;

    @Autowired
    private TaskRepository repository;

    public TaskService(MeterRegistry meterRegistry) {
        myCounter = Counter.builder("my_custom_counter")
                .description("Counts something very important")
                .register(meterRegistry);
        myTimer = Timer.builder("my_custom_timer")
                .description("Timing something very important")
                .register(meterRegistry);
    }


    public Task createTask(Task task) {
        return repository.save(task);
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        myCounter.increment();
        return repository.findById(id);
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task task = repository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        return repository.save(task);
    }

    public List<Task> getTasksByStatus(Status status) {
        return repository.findByStatus(status);
    }

    public Task updateTaskStatus(Long id, Task updatedTask) {
        Task task = repository.findById(id).orElseThrow(() -> new RuntimeException("task not found"));
        task.setStatus(task.getStatus());
        return repository.save(task);
    }

    public void deleteTask(Long id) {
        myTimer.record(() -> {
            repository.deleteById(id);
        });

    }

}
