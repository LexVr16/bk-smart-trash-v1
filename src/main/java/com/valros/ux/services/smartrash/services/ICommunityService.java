package com.valros.ux.services.smartrash.services;

import com.valros.ux.services.model.Community;
import com.valros.ux.services.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICommunityService {

    Community getCommunityById(String id);
    List<Community> getAllCommunities();
    Community createCommunity(Community community);
    ResponseEntity<Void> deleteCommunityById(String id);
    Community updateCommunity(Community community);
}
