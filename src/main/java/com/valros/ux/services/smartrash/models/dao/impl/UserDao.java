package com.valros.ux.services.smartrash.models.dao.impl;

import com.valros.ux.services.model.User;
import com.valros.ux.services.smartrash.models.dao.IUserDao;
import com.valros.ux.services.smartrash.repositories.IUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class UserDao implements IUserDao {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public User getUserById(String id) {
        try {
            log.info("<<< In progress... - getUserById()");
            Optional<User> userOptional = iUserRepository.findById(Integer.parseInt(id));
            if (userOptional.isPresent()) {
                log.info("Complete - getUserById() >>>");
                return userOptional.get();
            }
            throw new RuntimeException("throw new NotFoundException - getAssignmentById()");
        } catch (Exception e) {
            log.error("Error - getUserById()" + e.getCause().getCause().getMessage());
            throw new RuntimeException("throw new RuntimeException - getUserById()", e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            log.info("<<< In progress... - getAllUsers()");
            List<User> userList = iUserRepository.findAll();
            log.info("Complete - getAllUsers() >>>");
            return userList;
        } catch (Exception e) {
            log.error("Error getAllUsers(): " + e.getCause().getCause().getMessage());
            throw new RuntimeException("throw new RuntimeException - getAllUsers()", e);
        }
    }

    @Override
    public User createUser(User user) {
        try {
            log.info("<<< In progress... - createUser()");
            User usuario = new User();
            usuario.setDni(user.getDni());
            usuario.setName(user.getName());
            usuario.setLastName(user.getLastName());
            usuario.setAddress(user.getAddress());
            usuario.setEmail(user.getEmail());
            usuario.setPhoneNumber(user.getPhoneNumber());
            usuario.setPassword(user.getPassword());
            usuario.setUserType(user.getUserType());
            usuario.setCommunityId(user.getCommunityId());
            iUserRepository.save(usuario);
            log.info("Complete - createUser() >>>");
            return usuario;
        } catch (Exception e) {
            log.error("Error createUser(): " + e.getCause().getCause().getMessage());
            throw new RuntimeException("throw new RuntimeException - createUser()", e);
        }
    }

    @Override
    public ResponseEntity<Void> postLogin(User user) {
        try {
            log.info("<<< In progress... - postLogin()");
            User userExisting = iUserRepository.findLogin(user.getEmail(), user.getPassword());
            if (userExisting !=null) {
                log.info("Complete - postLogin() >>>");
                return ResponseEntity.ok().build();
            }
            throw new RuntimeException("throw new NotFoundException - postLogin()");
        } catch (RuntimeException nf) {
            log.info("ERROR - postLogin() >>>");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Exception e) {
            log.error("Error - getUserById() >>>" + e.getCause().getCause().getMessage());
            throw new RuntimeException("throw new RuntimeException - postLogin() >>>", e);
        }
    }

    @Override
    public ResponseEntity<Void> deleteUserById(String id) {
        try {
            log.info("<<< In progress... - deleteUserById()");
            iUserRepository.deleteById(Integer.parseInt(id));
            log.info("Complete - deleteUserById() >>>");
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.error("Error deleteUserById(): " + e.getCause().getCause().getMessage());
            throw new RuntimeException("throw new RuntimeException - deleteUserById()", e);
        }
    }

    @Override
    public User updateUser(User user) {
        try {
            log.info("<<< In progress... - updateUser()");
            Optional<User> existingUserOptional = iUserRepository.findById(user.getUserId());

            if (existingUserOptional.isPresent()) {
                User existingUser = existingUserOptional.get();
                existingUser.setDni(user.getDni());
                existingUser.setName(user.getName());
                existingUser.setLastName(user.getLastName());
                existingUser.setAddress(user.getAddress());
                existingUser.setEmail(user.getEmail());
                existingUser.setPhoneNumber(user.getPhoneNumber());
                existingUser.setPassword(user.getPassword());
                existingUser.setUserType(user.getUserType());
                existingUser.setCommunityId(user.getCommunityId());

                User updatedUser = iUserRepository.save(existingUser);
                log.info("Complete - updateUser() >>>");
                return updatedUser;
            } else {
                log.info("ERROR - updateUser() >>>");
                throw new RuntimeException("throw new NotFoundException - updateUser()");
            }
        } catch (Exception e) {
            log.error("Error - updateUser(): " + e.getMessage());
            throw new RuntimeException("throw new RuntimeException - updateUser()", e);
        }
    }

    @Override
    public List<User> getAllUsersByCommunityId(String communityId) {
        try {
            log.info("<<< In progress... - getUserById()");
            List<User> userList = iUserRepository.getAllUsersByCommunityId(communityId);
            if (userList != null) {
                log.info("Complete - getUserById() >>>");
                return userList;
            }
            throw new RuntimeException("throw new NotFoundException - getAssignmentById()");
        } catch (Exception e) {
            log.error("Error - getUserById()" + e.getCause().getCause().getMessage());
            throw new RuntimeException("throw new RuntimeException - getUserById()", e);
        }
    }
}
