package com.task.app.demo.repositories;

import com.task.app.demo.repositories.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "SELECT u FROM UserEntity u WHERE u.email = ?1 AND u.password = ?2")
    UserEntity login(String email, String password);

    @Query(value = "SELECT u FROM UserEntity u WHERE u.email = ?1")
    UserEntity verificationEmail(String email);
}
