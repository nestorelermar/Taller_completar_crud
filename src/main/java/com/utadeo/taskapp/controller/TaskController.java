package com.utadeo.taskapp.controller;

import com.utadeo.taskapp.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.utadeo.taskapp.dto.TaskDto;
import com.utadeo.taskapp.model.Task;
import com.utadeo.taskapp.service.ITaskService;

@RestController
@RequestMapping("task")
public class TaskController {

    private ITaskService taskService;

    TaskController(ITaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping
    Task store(@RequestBody TaskDto taskDto){
        return this.taskService.createTask(taskDto);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
        return new ApiResponse(
                HttpStatus.OK.value(),
                "La tarea se ha eliminado correctamente",
                null
        );
    }
}
