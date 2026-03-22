package com.example.taskmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.taskmanager.model.Task;

import com.example.taskmanager.repository.TaskRepository;

@Service

public class TaskService {

    @Autowired

    private TaskRepository taskRepository;

    public Task createTask(Task task) {

        return taskRepository.save(task);

    }

    public List<Task> getAllTasks() {

        return taskRepository.findAll();

    }

    public Task getTaskById(Long id) {

        return taskRepository.findById(id).orElse(null);

    }

    public void deleteTask(Long id) {

        taskRepository.deleteById(id);

    }

}