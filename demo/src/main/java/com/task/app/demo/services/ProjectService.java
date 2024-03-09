package com.task.app.demo.services;

import com.task.app.demo.repositories.entities.ProjectEntity;
import com.task.app.demo.repositories.entities.UserEntity;

import java.util.List;

public interface ProjectService {

    List<ProjectEntity> findByUser(Long userId);

    void create(ProjectEntity project, Long userId);

    void update(Long id, ProjectEntity projectUpdated);

    void delete(Long id);

    ProjectEntity findById(UserEntity user,Long id);
}
