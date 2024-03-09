package com.task.app.demo.repositories;

import com.task.app.demo.repositories.entities.ProjectEntity;
import com.task.app.demo.repositories.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

    List<ProjectEntity> findByUser(UserEntity user);

    ProjectEntity findByUserAndId(UserEntity user, Long idProject);
}
