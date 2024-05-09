package com.valros.ux.services.smartrash.services;

import com.valros.ux.services.model.User;
import com.valros.ux.services.smartrash.models.dao.IUserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService implements IUserService{

    @Autowired
    IUserDao userDao;

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User createUser(User user) {
        return userDao.createUser(user);
    }
}
