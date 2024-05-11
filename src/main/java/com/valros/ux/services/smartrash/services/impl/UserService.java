package com.valros.ux.services.smartrash.services.impl;

import com.valros.ux.services.model.User;
import com.valros.ux.services.smartrash.models.dao.IUserDao;
import com.valros.ux.services.smartrash.services.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User getUserById(String id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User createUser(User user) {
        return userDao.createUser(user);
    }

    @Override
    public ResponseEntity<Void> deleteUserById(String id) {
        return  userDao.deleteUserById(id);
    }

    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }
}
