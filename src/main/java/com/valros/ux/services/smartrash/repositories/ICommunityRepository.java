package com.valros.ux.services.smartrash.repositories;

import com.valros.ux.services.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommunityRepository extends JpaRepository<Community,Integer> {
}
