package com.valros.ux.services.smartrash.models.dao;

import com.valros.ux.services.model.User;
import com.valros.ux.services.smartrash.repositories.IUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class UserDao implements IUserDao{

    @Autowired
    IUserRepository userRepository;

    @Override
    public List<User> getUsers() {
        List<User> userList;
        try {
            log.info("Obteniendo los usuarios - getUsers()");
            userList = userRepository.findAll();
            log.info("Usuarios obtenidos correctamente - getUsers()");
        } catch (Exception e) {
            log.error("Error al obtener los usuarios getUsers(): " + e.getMessage());
            throw new RuntimeException("Error al obtener los usuarios", e);
        }
        return userList;
    }

    @Override
    public User createUser(User user) {
        User usuario;
        try {
            log.info("Se inició la creación del usuario - createUser()");
            usuario = new User();
            usuario.setName(user.getName());
            usuario.setLastname(user.getLastname());
            usuario.setDni(user.getDni());
            usuario.setEmail(user.getEmail());
            usuario.setPhoneNumber(user.getPhoneNumber());
            usuario.setPassword(user.getPassword());
            usuario.setUserType(user.getUserType());
            usuario.setCommunityId(user.getCommunityId());
            userRepository.save(usuario);
            log.info("Creación del usuario correctamente - createUser()");
        } catch (Exception e) {
            log.error("Error al crear el usuario: " + e.getMessage());
            throw new RuntimeException("Error al crear el usuario", e);
        }
        return usuario;
    }
}
