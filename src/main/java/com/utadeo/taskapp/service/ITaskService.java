package com.utadeo.taskapp.service;

import com.utadeo.taskapp.dto.TaskDto;
import com.utadeo.taskapp.model.Task;
import com.utadeo.taskapp.model.User;

import java.util.List;

public interface ITaskService {
    
    Task createTask(TaskDto task);
    void deleteTask(Long id);

}
