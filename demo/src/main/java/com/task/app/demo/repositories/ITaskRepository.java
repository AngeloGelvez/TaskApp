package com.task.app.demo.repositories;

import com.task.app.demo.repositories.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITaskRepository extends JpaRepository<TaskEntity, Long> {

    @Query(value = "SELECT * FROM tasks t WHERE t.project_id = ?1", nativeQuery = true)
    List<TaskEntity> allTaskByProject(Long id);
}
