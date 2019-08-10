package com.codegym.pms.service;

import com.codegym.pms.model.Task;

public interface TaskService {
    void save(Task task);

    Iterable<Task> findAll();

    Task findById(Long id);

    void remove(Long id);
}
