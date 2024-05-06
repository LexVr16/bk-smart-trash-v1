package com.valros.ux.services.smartrash.controller;

import com.valros.ux.services.controller.UsuariosApi;
import com.valros.ux.services.model.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Slf4j
@Controller
@RequestMapping("${application.api.base-path}")
public class SmartrashControllerImpl implements UsuariosApi {
    @Override
    public ResponseEntity<Usuario> actualizarUsuarioPorID(String idUsuario, Usuario usuario) {
        return null;
    }

    @Override
    public ResponseEntity<Void> eliminarUsuarioPorID(String idUsuario) {
        return null;
    }

    @Override
    public ResponseEntity<List<Usuario>> getUsuarios() {
        log.info("Entro a este metodo getUsuarios()");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Usuario> obtenerUsuarioPorID(String idUsuario) {
        return null;
    }

    @Override
    public ResponseEntity<Usuario> postCreateUser(Usuario usuario) {
        return null;
    }
}
