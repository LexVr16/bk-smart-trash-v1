package com.valros.ux.services.smartrash.controllers;

import com.valros.ux.services.controller.TruksApi;
import com.valros.ux.services.model.Truk;
import com.valros.ux.services.smartrash.services.ITrukService;
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
public class TrukController implements TruksApi {

    @Autowired
    private ITrukService iTrukService;

    @Override
    public ResponseEntity<Truk> getTrukById(String trukId) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(iTrukService.getTrukById(trukId));
        } catch (Exception e) {
            log.error("Error retrieving getTrukById", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<List<Truk>> getAllTruks() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(iTrukService.getAllTruks());
        } catch (Exception e) {
            log.error("Error retrieving getAllTruks", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Truk> postCreateTruk(Truk truk) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(iTrukService.createTruk(truk));
        } catch (Exception e) {
            log.error("Error retrieving postCreateTruk", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Void> trukDeleteById(String trukId) {
        try {
            return iTrukService.deleteTrukById(trukId);
        } catch (Exception e) {
            log.error("Error retrieving trukDeleteById", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Truk> trukUpdateById(String trukId, Truk truk) {
        try {
            return ResponseEntity.ok(iTrukService.updateTruk(truk));
        } catch (Exception e) {
            log.error("Error retrieving trukUpdateById", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
