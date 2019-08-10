package com.codegym.pms.service.impl;

import com.codegym.pms.model.Project;
import com.codegym.pms.repository.ProjectRepository;
import com.codegym.pms.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Override
    public void save(Project project) {
        projectRepository.save(project);
    }

    @Override
    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(Long id) {
        return projectRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        projectRepository.delete(id);
    }
}
