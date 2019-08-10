package com.codegym.pms.service.impl;

import com.codegym.pms.model.Task;
import com.codegym.pms.repository.TaskRepository;
import com.codegym.pms.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Override
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Override
    public Iterable<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        taskRepository.delete(id);
    }
}
