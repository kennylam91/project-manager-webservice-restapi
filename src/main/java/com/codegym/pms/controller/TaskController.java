package com.codegym.pms.controller;

import com.codegym.pms.model.Task;
import com.codegym.pms.model.Task;
import com.codegym.pms.service.TaskService;
import com.codegym.pms.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    //-------------------Retrieve All Tasks--------------------------------------------------------

    @RequestMapping(value = "/tasks", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Task>> listAllTasks() {
        List<Task> tasks = (List<Task>) taskService.findAll();
        if (tasks.isEmpty()) {
            return new ResponseEntity<List<Task>>(HttpStatus.NO_CONTENT);}
        return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
    }

    //-------------------Retrieve Single Task--------------------------------------------------------

    @RequestMapping(value = "tasks/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> getTask(@PathVariable("id") Long id) {
        Task task = taskService.findById(id);
        if (task == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else
            return new ResponseEntity<>(task, HttpStatus.OK);
    }

    //----------------Create a task----------------------
    @RequestMapping(value = "tasks", method = RequestMethod.POST)
    public ResponseEntity<Void> createTask(@RequestBody Task task, UriComponentsBuilder uri) {
        taskService.save(task);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri.path("/tasks/{id}").buildAndExpand(task.getId()).toUri());
        return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);

    }

    //-----------------Update a task---------------
    @RequestMapping(value = "tasks/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Task> updateTask(@RequestBody Task task, @PathVariable("id") Long id) {
        Task currentTask = taskService.findById(id);
        if (currentTask == null) {
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        } else {
            currentTask.setTitle(task.getTitle());
            currentTask.setContent(task.getContent());
            taskService.save(currentTask);
            return new ResponseEntity<Task>(currentTask, HttpStatus.OK);
        }
    }

    //-------------delete Task----------------
    @RequestMapping(value = "tasks/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Task> deleteTask(@PathVariable("id") Long id) {
        Task task = taskService.findById(id);
        if (task == null) {
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }
        taskService.remove(id);
        return new ResponseEntity<Task>(HttpStatus.NO_CONTENT);
    }
}

