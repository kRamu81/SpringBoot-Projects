package com.example.taskmanager.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.example.taskmanager.model.Task;

import com.example.taskmanager.service.TaskService;

@RestController
@RequestMapping("/tasks")

public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);

    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();

    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);

    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "Task deleted successfully";

    }

}