package com.valros.ux.services.smartrash.repositories;

import com.valros.ux.services.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {

}
