package com.valros.ux.services.smartrash.models.dao;

import com.valros.ux.services.model.User;

import java.util.List;

public interface IUserDao {
    List<User> getUsers();
    User createUser(User user);
}
