package com.valros.ux.services.smartrash.models.dao;

import com.valros.ux.services.model.User;
import com.valros.ux.services.smartrash.repositories.IUserRepository;
import javassist.NotFoundException;
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
    IUserRepository userRepository;

    @Override
    public User getUserById(String id) {
        try {
            log.info("<<< Iniciando búsqueda del usuario por ID - getUserById()");
            Optional<User> userOptional = userRepository.findById(Integer.parseInt(id));
            if (userOptional.isPresent()) {
                User usuario = userOptional.get();
                log.info("Usuario encontrado correctamente - getUserById() >>>");
                return usuario;
            }
            return userOptional.orElseThrow();
        } catch (Throwable e) {
            log.error("!!! Error al crear el usuario: " + e.getCause().getCause().getMessage());
            throw new RuntimeException("Error getUserById", e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            log.info("<<< Obteniendo los usuarios - getUsers()");
            List<User> userList = userRepository.findAll();
            log.info("Usuarios obtenidos correctamente - getUsers() >>>");
            return userList;
        } catch (Exception e) {
            log.error("Error al obtener los usuarios getUsers(): " + e.getMessage());
            throw new RuntimeException("Error getAllUsers", e);
        }
    }

    @Override
    public User createUser(User user) {
        try {
            log.info("<<< Se inició la creación del usuario - createUser()");
            User usuario = new User();
            usuario.setName(user.getName());
            usuario.setLastname(user.getLastname());
            usuario.setDni(user.getDni());
            usuario.setEmail(user.getEmail());
            usuario.setPhoneNumber(user.getPhoneNumber());
            usuario.setPassword(user.getPassword());
            usuario.setUserType(user.getUserType());
            usuario.setCommunityId(user.getCommunityId());
            userRepository.save(usuario);
            log.info("Creación del usuario correctamente - createUser() >>>");
            return usuario;
        } catch (Throwable e) {
            log.error("!!! Error al crear el usuario: " + e.getCause().getCause().getMessage());
            throw new RuntimeException("Error createUser", e);
        }
    }

    @Override
    public ResponseEntity<Void> deleteUserById(String id) {
        try {
            log.info("<<< Se inició la eliminación del usuario - deleteUserById()");
            userRepository.deleteById(Integer.parseInt(id));
            log.info("Usuario eliminado correctamente >>>");
            return ResponseEntity.noContent().build();
        } catch (Throwable e) {
            log.error("!!! Error deleteUserById " + e.getCause().getCause().getMessage());
            throw new RuntimeException("Error al crear el usuario", e);
        }
    }

    @Override
    public User updateUser(User user) {
        try {
            log.info("<<< Se inició la actualización del usuario - updateUser()");
            Optional<User> existingUserOptional = userRepository.findById(user.getUserId());

            if (existingUserOptional.isPresent()) {
                User existingUser = existingUserOptional.get();
                // Actualizar los campos del usuario existente con los valores del usuario pasado como parámetro
                existingUser.setName(user.getName());
                existingUser.setLastname(user.getLastname());
                existingUser.setDni(user.getDni());
                existingUser.setEmail(user.getEmail());
                existingUser.setPhoneNumber(user.getPhoneNumber());
                existingUser.setPassword(user.getPassword());
                existingUser.setUserType(user.getUserType());
                existingUser.setCommunityId(user.getCommunityId());

                User updatedUser = userRepository.save(existingUser); // Guardar la actualización en la base de datos
                log.info("Actualización del usuario correctamente - updateUser() >>>");
                return updatedUser; // Devolver el usuario actualizado
            } else {
                log.error("Usuario no encontrado para actualizar");
                throw new NotFoundException("Usuario no encontrado para actualizar");
            }
        } catch (Throwable e) {
            log.error("!!! Error al actualizar el usuario: " + e.getMessage());
            throw new RuntimeException("Error al actualizar el usuario", e);
        }
    }
}
