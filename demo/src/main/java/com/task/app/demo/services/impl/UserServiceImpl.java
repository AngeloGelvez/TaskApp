package com.task.app.demo.services.impl;

import com.task.app.demo.repositories.IUserRepository;
import com.task.app.demo.repositories.entities.UserEntity;
import com.task.app.demo.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UserEntity> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    @Transactional
    public UserEntity login(String email, String password) {
        return iUserRepository.login(email, password);
    }

    @Override
    @Transactional
    public void create(UserEntity user) {
        user.setRegisterDate(LocalDate.now());

        iUserRepository.save(user);
    }

    @Override
    @Transactional
    public UserEntity update(Long id, UserEntity userUpdated) {
        Optional<UserEntity> optionalUser = iUserRepository.findById(id);

        if(optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();

            user.setName(
                    (userUpdated.getName() == null || userUpdated.getName().isEmpty())? user.getName(): userUpdated.getName()
            );
            user.setEmail(
                    (userUpdated.getEmail() == null || userUpdated.getEmail().isEmpty())? user.getEmail(): userUpdated.getEmail()
            );
            user.setPhone(
                    (userUpdated.getPhone() == null || userUpdated.getPhone().isEmpty())? user.getPhone(): userUpdated.getPhone()
            );
            user.setPassword(
                    (userUpdated.getPassword() == null || userUpdated.getPassword().isEmpty())? user.getPassword(): userUpdated.getPassword()
            );

            iUserRepository.save(user);
            return user;
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        iUserRepository.deleteById(id);
    }

    @Override
    public Boolean findByEmail(String email) {
        if(iUserRepository.verificationEmail(email) != null) return true;

        return false;
    }

    @Override
    public UserEntity findById(Long id) {
        Optional<UserEntity> userOp = iUserRepository.findById(id);

        if(userOp.isPresent()) {
            return userOp.get();
        }

        return null;
    }
}
