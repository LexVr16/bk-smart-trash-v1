package com.valros.ux.services.smartrash.models.dao;

import com.valros.ux.services.model.Truk;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITrukDao {

    Truk getTrukById(String id);
    List<Truk> getAllTruks();
    Truk createTruk(Truk truk);
    ResponseEntity<Void> deleteTrukById(String id);
    Truk updateTruk(Truk truk);
}
