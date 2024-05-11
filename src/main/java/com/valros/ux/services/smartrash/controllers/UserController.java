package com.valros.ux.services.smartrash.controllers;

import com.valros.ux.services.controller.UsersApi;
import com.valros.ux.services.model.User;
import com.valros.ux.services.smartrash.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("${application.api.base-path}")
public class UserController implements UsersApi {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<User> getUserById(String userId) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(userService.getUserById(userId));
        } catch (Exception e) {
            log.error("Error retrieving getUsers", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<List<User>> getUsers() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(userService.getAllUsers());
        } catch (Exception e) {
            log.error("Error retrieving getUsers", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<User> postCreateUser(User user) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(userService.createUser(user));
        } catch (Exception e) {
            log.error("Error retrieving postCreateUser", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Void> userDeleteById(String userId) {
        try {
            return userService.deleteUserById(userId);
        } catch (Exception e) {
            log.error("Error retrieving postCreateUser", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<User> userUpdateById(String userId, User user) {
        try {
            return ResponseEntity.ok(userService.updateUser(user));
        } catch (Exception e) {
            log.error("Error retrieving postCreateUser", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}