package com.valros.ux.services.smartrash.models.dao.impl;

import com.valros.ux.services.model.Community;
import com.valros.ux.services.smartrash.models.dao.ICommunityDao;
import com.valros.ux.services.smartrash.repositories.ICommunityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class CommunityDao implements ICommunityDao {

    @Autowired
    private ICommunityRepository iCommunityRepository;

    @Override
    public Community getCommunityById(String id) {
        try {
            log.info("<<< In progress... - getCommunityById()");
            Optional<Community> communityOptional = iCommunityRepository.findById(Integer.parseInt(id));
            if (communityOptional.isPresent()) {
                log.info("Complete - getCommunityById() >>>");
                return communityOptional.get();
            }
            throw new RuntimeException("throw new NotFoundException - getCommunityById()");
        } catch (Throwable e) {
            log.error("Error getCommunityById(): " + e.getCause().getCause().getMessage());
            throw new RuntimeException("throw new RuntimeException - getCommunityById()",e);
        }
    }

    @Override
    public List<Community> getAllCommunities() {
        try {
            log.info("<<< In progress... getAllCommunities()");
            List<Community> communityList = iCommunityRepository.findAll();
            log.info("Complete - getAllCommunities() >>>");
            return communityList;
        } catch (Exception e) {
            log.error("Error  getAllCommunities(): " + e.getCause().getCause().getMessage());
            throw new RuntimeException("throw new RuntimeException - getAllCommunities()",e);
        }
    }

    @Override
    public Community createCommunity(Community community) {
        try {
            log.info("<<< In progress... - createCommunity()");
            Community objTruk = new Community();
            objTruk.setCommunityName(community.getCommunityName());
            iCommunityRepository.save(objTruk);
            log.info("Complete - createCommunity() >>>");
            return objTruk;
        } catch (Exception e) {
            log.error("Error createCommunity(): " + e.getCause().getCause().getMessage());
            throw new RuntimeException("throw new RuntimeException - createCommunity()", e);
        }
    }

    @Override
    public ResponseEntity<Void> deleteCommunityById(String id) {
        try {
            log.info("<<< In progress... - deleteCommunityById()");
            iCommunityRepository.deleteById(Integer.parseInt(id));
            log.info("Complete - deleteCommunityById() >>>");
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.error("Error deleteCommunityById(): " + e.getCause().getCause().getMessage());
            throw new RuntimeException("throw new RuntimeException - deleteCommunityById()", e);
        }
    }

    @Override
    public Community updateCommunity(Community community) {
        try {
            log.info("<<< In progress... - updateTruk()");
            Optional<Community> existingCommunityOptional = iCommunityRepository.findById(community.getCommunityId());
            if (existingCommunityOptional.isPresent()) {
                Community existingCommunity = existingCommunityOptional.get();
                existingCommunity.setCommunityName(community.getCommunityName());
                Community updatedCommunity = iCommunityRepository.save(existingCommunity);
                log.info("Complete - updateTruk() >>>");
                return updatedCommunity;
            } else {
                log.info("ERROR - updateTruk() >>>");
                throw new RuntimeException("throw new NotFoundException - updateTruk()");
            }
        } catch (Exception e) {
            log.error("Error - updateTruk(): " + e.getMessage());
            throw new RuntimeException("throw new RuntimeException - updateTruk()", e);
        }
    }
}
