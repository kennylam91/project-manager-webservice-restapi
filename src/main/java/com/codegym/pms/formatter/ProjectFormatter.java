package com.codegym.pms.formatter;

import com.codegym.pms.model.Project;
import com.codegym.pms.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class ProjectFormatter implements Formatter<Project> {
    private ProjectService projectService;

    @Autowired
    public ProjectFormatter(ProjectService projectService){
        this.projectService= projectService;
    }
    @Override
    public Project parse(String text, Locale locale) throws ParseException {
        return this.projectService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Project object, Locale locale) {
        return "[" + object.getId() + ","+object.getTitle()+"]";
    }
}
