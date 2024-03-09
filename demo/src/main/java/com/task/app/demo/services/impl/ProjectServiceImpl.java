package com.task.app.demo.services.impl;

import com.task.app.demo.repositories.IUserRepository;
import com.task.app.demo.repositories.ProjectRepository;
import com.task.app.demo.repositories.entities.ProjectEntity;
import com.task.app.demo.repositories.entities.UserEntity;
import com.task.app.demo.services.ProjectService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ProjectEntity> findByUser(Long userId) {
        Optional<UserEntity> optionalUser = iUserRepository.findById(userId);
        if (optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();
            return projectRepository.findByUser(user);
        }

        return null;
    }

    @Override
    @Transactional
    public void create(ProjectEntity project, Long userId) {
        UserEntity user = iUserRepository.findById(userId).get();
        project.setUser(user);
        projectRepository.save(project);
    }

    @Override
    @Transactional
    public void update(Long id, ProjectEntity projectUpdated) {
        Optional<ProjectEntity> optionalProject = projectRepository.findById(id);

        if(optionalProject.isPresent()) {
            ProjectEntity project = optionalProject.get();

            project.setName(
                    (projectUpdated.getName() == null || projectUpdated.getName().isEmpty())? project.getName(): projectUpdated.getName()
            );
            project.setDescription(
                    (projectUpdated.getDescription() == null || projectUpdated.getDescription().isEmpty())? project.getDescription(): projectUpdated.getDescription()
            );
            project.setStartDate(
                    (projectUpdated.getStartDate() == null)? project.getStartDate(): projectUpdated.getStartDate()
            );
            project.setEndDate(
                    (projectUpdated.getEndDate() == null)? project.getEndDate(): projectUpdated.getEndDate()
            );
            project.setTag(
                    (projectUpdated.getTag() == null || projectUpdated.getTag().isEmpty())? project.getTag(): projectUpdated.getTag()
            );
            project.setColor(
                    (projectUpdated.getColor() == null || projectUpdated.getColor().isEmpty())? project.getColor(): projectUpdated.getColor()
            );

            projectRepository.save(project);
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public ProjectEntity findById(UserEntity user, Long id) {
        ProjectEntity projects = projectRepository.findByUserAndId(user, id);

        return projects;
    }
}
