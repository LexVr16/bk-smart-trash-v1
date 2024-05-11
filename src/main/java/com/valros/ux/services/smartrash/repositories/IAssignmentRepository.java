package com.valros.ux.services.smartrash.repositories;

import com.valros.ux.services.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAssignmentRepository extends JpaRepository<Assignment,Integer> {
}
