package com.task.app.demo.services;

import com.task.app.demo.repositories.entities.TaskEntity;

import java.util.List;

public interface TaskService {


    List<TaskEntity> allTaskByProject(Long idProject);

    TaskEntity findById(Long idTask);

    void createTask(TaskEntity task);

    void deleteTask(Long id);
}
