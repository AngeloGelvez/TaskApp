package com.task.app.demo.services;

import com.task.app.demo.repositories.entities.UserEntity;

import java.util.List;

public interface IUserService {

    List<UserEntity> findAll();

    UserEntity login(String email, String password);

    void create(UserEntity user);

    UserEntity update(Long id, UserEntity userUpdated);

    void delete(Long id);

    Boolean findByEmail(String email);

    UserEntity findById(Long id);
}
