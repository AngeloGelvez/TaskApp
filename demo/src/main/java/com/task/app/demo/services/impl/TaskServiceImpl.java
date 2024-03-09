package com.task.app.demo.services.impl;

import com.task.app.demo.repositories.ITaskRepository;
import com.task.app.demo.repositories.entities.TaskEntity;
import com.task.app.demo.services.TaskService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private ITaskRepository iTaskRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TaskEntity> allTaskByProject(Long idProject) {
        List<TaskEntity> tasks = iTaskRepository.allTaskByProject(idProject);

        if(!tasks.isEmpty()) {
            return tasks;
        }

        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public TaskEntity findById(Long idTask) {
        Optional<TaskEntity> taskOp = iTaskRepository.findById(idTask);

        if(taskOp.isPresent()) {
            return taskOp.get();
        }

        return null;
    }

    @Override
    @Transactional
    public void createTask(TaskEntity task) {
        iTaskRepository.save(task);
    }

    @Override
    @Transactional
    public void deleteTask(Long id) {
        iTaskRepository.deleteById(id);
    }
}
