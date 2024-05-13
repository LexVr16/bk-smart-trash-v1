package com.valros.ux.services.smartrash.controllers;

import com.valros.ux.services.controller.UsersApi;
import com.valros.ux.services.model.User;
import com.valros.ux.services.smartrash.services.IUserService;
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
    private IUserService iUserService;

    @Override
    public ResponseEntity<User> getUserById(String userId) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(iUserService.getUserById(userId));
        } catch (Exception e) {
            log.error("Error retrieving getUsers", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(iUserService.getAllUsers());
        } catch (Exception e) {
            log.error("Error retrieving getAllUsers", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<User> postCreateUser(User user) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(iUserService.createUser(user));
        } catch (Exception e) {
            log.error("Error retrieving postCreateUser", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Void> postLogin(User user) {
        try {
            if (user.getDni() !=null || user.getName() !=null || user.getLastName() !=null
                    || user.getPhoneNumber()!=null || user.getUserType()!=null || user.getCommunityId()!=null) {
                log.error("BAD_REQUEST retrieving postLogin");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
           } else if(user.getEmail() !=null && user.getPassword() != null) {
                return iUserService.postLogin(user);
           }
            log.error("BAD_REQUEST retrieving postLogin");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            log.error("Error retrieving postLogin", e);
            return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).build();
        }
    }

    @Override
    public ResponseEntity<Void> userDeleteById(String userId) {
        try {
            return iUserService.deleteUserById(userId);
        } catch (Exception e) {
            log.error("Error retrieving postCreateUser", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<User> userUpdateById(String userId, User user) {
        try {
            return ResponseEntity.ok(iUserService.updateUser(user));
        } catch (Exception e) {
            log.error("Error retrieving postCreateUser", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}