package com.valros.ux.services.smartrash.models.dao.impl;

import com.valros.ux.services.model.Truk;
import com.valros.ux.services.smartrash.models.dao.ITrukDao;
import com.valros.ux.services.smartrash.repositories.ITrukRepository;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class TrukDao implements ITrukDao {

    @Autowired
    private ITrukRepository trukRepository;

    @Override
    public Truk getTrukById(String id) {
        try {
            log.info("<<< In progress... - getTrukById()");
            Optional<Truk> trukOptional = trukRepository.findById(Integer.parseInt(id));
            if (trukOptional.isPresent()) {
                log.info("Complete - getTrukById() >>>");
                return trukOptional.get();
            }
            throw new NotFoundException("throw new NotFoundException - getTrukById()");
        } catch (Throwable e) {
            log.error("Error getTrukById(): " + e.getCause().getCause().getMessage());
            throw new RuntimeException("throw new RuntimeException - getTrukById()",e);
        }
    }

    @Override
    public List<Truk> getAllTruks() {
        try {
            log.info("<<< In progress... getAllTruks()");
            List<Truk> trukList = trukRepository.findAll();
            log.info("Complete - getAllTruks() >>>");
            return trukList;
        } catch (Exception e) {
            log.error("Error  getAllTruks(): " + e.getCause().getCause().getMessage());
            throw new RuntimeException("throw new RuntimeException - getAllTruks()",e);
        }
    }

    @Override
    public Truk createTruk(Truk truk) {
        try {
            log.info("<<< In progress... - createTruk()");
            Truk objTruk = new Truk();
            objTruk.setModel(truk.getModel());
            objTruk.setPlaque(truk.getPlaque());
            objTruk.setStatus(truk.getStatus());
            trukRepository.save(objTruk);
            log.info("Complete - createTruk() >>>");
            return objTruk;
        } catch (Exception e) {
            log.error("Error createTruk(): " + e.getCause().getCause().getMessage());
            throw new RuntimeException("throw new RuntimeException - createTruk()", e);
        }
    }

    @Override
    public ResponseEntity<Void> deleteTrukById(String id) {
        try {
            log.info("<<< In progress... - deleteTrukById()");
            trukRepository.deleteById(Integer.parseInt(id));
            log.info("Complete - deleteTrukById() >>>");
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.error("Error deleteTrukById(): " + e.getCause().getCause().getMessage());
            throw new RuntimeException("throw new RuntimeException - deleteTrukById()", e);
        }
    }

    @Override
    public Truk updateTruk(Truk truk) {
        try {
            log.info("<<< In progress... - updateTruk()");
            Optional<Truk> existingTrukOptional = trukRepository.findById(truk.getTrukId());
            if (existingTrukOptional.isPresent()) {
                Truk existingTruk = existingTrukOptional.get();
                existingTruk.setModel(truk.getModel());
                existingTruk.setPlaque(truk.getPlaque());
                existingTruk.setStatus(truk.getStatus());
                Truk updatedTruk = trukRepository.save(existingTruk);
                log.info("Complete - updateTruk() >>>");
                return updatedTruk;
            } else {
                log.info("ERROR - updateTruk() >>>");
                throw new NotFoundException("throw new NotFoundException - updateTruk()");
            }
        } catch (Exception e) {
            log.error("Error - updateTruk(): " + e.getMessage());
            throw new RuntimeException("throw new RuntimeException - updateTruk()", e);
        }
    }
}
