package com.valros.ux.services.smartrash.repositories;

import com.valros.ux.services.model.Truk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrukRepository extends JpaRepository<Truk,Integer> {
}
