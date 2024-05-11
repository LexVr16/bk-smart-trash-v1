package com.valros.ux.services.smartrash.services;

import com.valros.ux.services.model.Truk;
import com.valros.ux.services.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITrukService {

    Truk getTrukById(String id);
    List<Truk> getAllTruks();
    Truk createTruk(Truk truk);
    ResponseEntity<Void> deleteTrukById(String id);
    Truk updateTruk(Truk truk);
}
