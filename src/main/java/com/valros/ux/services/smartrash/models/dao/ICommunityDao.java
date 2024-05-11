package com.valros.ux.services.smartrash.models.dao;

import com.valros.ux.services.model.Community;
import com.valros.ux.services.model.Notification;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICommunityDao {

    Community getCommunityById(String id);
    List<Community> getAllCommunities();
    Community createCommunity(Community community);
    ResponseEntity<Void> deleteCommunityById(String id);
    Community updateCommunity(Community community);
}
