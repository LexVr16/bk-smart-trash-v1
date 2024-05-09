package com.valros.ux.services.smartrash.services;

import com.valros.ux.services.model.User;

import java.util.List;

public interface IUserService {
    List<User> getUsers();
    User createUser(User user);
}
