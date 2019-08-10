package com.codegym.pms.repository;

import com.codegym.pms.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task,Long> {
}
