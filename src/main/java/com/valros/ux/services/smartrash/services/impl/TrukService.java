package com.valros.ux.services.smartrash.services.impl;

import com.valros.ux.services.model.Truk;
import com.valros.ux.services.smartrash.models.dao.ITrukDao;
import com.valros.ux.services.smartrash.services.ITrukService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TrukService implements ITrukService {

    @Autowired
    private ITrukDao trukDao;

    @Override
    public Truk getTrukById(String id) {
        return trukDao.getTrukById(id);
    }

    @Override
    public List<Truk> getAllTruks() {
        return trukDao.getAllTruks();
    }

    @Override
    public Truk createTruk(Truk truk) {
        return trukDao.createTruk(truk);
    }

    @Override
    public ResponseEntity<Void> deleteTrukById(String id) {
        return trukDao.deleteTrukById(id);
    }

    @Override
    public Truk updateTruk(Truk truk) {
        return trukDao.updateTruk(truk);
    }
}
