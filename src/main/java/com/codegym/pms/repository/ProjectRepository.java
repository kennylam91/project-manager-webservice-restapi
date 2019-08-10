package com.codegym.pms.repository;

import com.codegym.pms.model.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
