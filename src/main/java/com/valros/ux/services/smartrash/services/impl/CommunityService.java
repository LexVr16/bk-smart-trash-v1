package com.valros.ux.services.smartrash.services.impl;

import com.valros.ux.services.model.Community;
import com.valros.ux.services.smartrash.models.dao.ICommunityDao;
import com.valros.ux.services.smartrash.services.ICommunityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CommunityService implements ICommunityService {

    @Autowired
    private ICommunityDao communityDao;

    @Override
    public Community getCommunityById(String id) {
        return communityDao.getCommunityById(id);
    }

    @Override
    public List<Community> getAllCommunities() {
        return communityDao.getAllCommunities();
    }

    @Override
    public Community createCommunity(Community community) {
        return communityDao.createCommunity(community);
    }

    @Override
    public ResponseEntity<Void> deleteCommunityById(String id) {
        return communityDao.deleteCommunityById(id);
    }

    @Override
    public Community updateCommunity(Community community) {
        return communityDao.updateCommunity(community);
    }
}
