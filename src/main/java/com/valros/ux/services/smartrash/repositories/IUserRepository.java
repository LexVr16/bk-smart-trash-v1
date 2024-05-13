package com.valros.ux.services.smartrash.repositories;

import com.valros.ux.services.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {

    @Query(value = "SELECT * FROM user WHERE email = :email and password = :password", nativeQuery = true)
    User findLogin(@Param("email") String email, @Param("password") String password);
}
