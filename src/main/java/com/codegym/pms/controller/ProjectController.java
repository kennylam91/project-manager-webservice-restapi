package com.codegym.pms.controller;

import com.codegym.pms.model.Project;
import com.codegym.pms.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.print.attribute.standard.Media;
import java.util.List;
import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    //-------------------Retrieve All Projects--------------------------------------------------------

    @RequestMapping(value = "/projects", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Project>> listAllProjects() {
        List<Project> projects = (List<Project>)projectService.findAll();
        if (projects.isEmpty()) {
            return new ResponseEntity<List<Project>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
    }

    //-------------------Retrieve Single Project--------------------------------------------------------

    @RequestMapping(value = "projects/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Project> getProject(@PathVariable("id") Long id){
        Project project = projectService.findById(id);
        if(project==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
            return new ResponseEntity<>(project,HttpStatus.OK);
    }

}
