package com.valros.ux.services.smartrash.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        // Personaliza la respuesta de acuerdo a tus necesidades
        String errorMessage = "Se produjo un error interno en el servidor.";
        // Loguea la excepción si es necesario
        log.error("Error interno en el servidor: {}", e.getMessage());
        // Devuelve una respuesta con un mensaje de error genérico y el código de estado 500 (Error interno del servidor)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<String> handleSqlException(SQLException e) {
        String errorMessage = "Error en la base de datos.";
        log.error("Error en la base de datos: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> Throwable(Throwable e) {
        String errorMessage = "Error en la base de datos<<<<<.";
        log.error("Error en la base de datos: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }
}
