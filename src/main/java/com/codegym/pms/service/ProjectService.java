package com.codegym.pms.service;

import com.codegym.pms.model.Project;
import com.codegym.pms.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ProjectService {
    void save(Project project);

    Iterable<Project> findAll();

    Project findById(Long id);

    void remove(Long id);
}
