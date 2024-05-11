package com.valros.ux.services.smartrash.models.dao;

import com.valros.ux.services.model.Assignment;
import com.valros.ux.services.model.Community;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IAssignmentDao {

    Assignment getAssignmentById(String id);
    List<Assignment> getAllAssignments();
    Assignment createAssignment(Assignment assignment);
    ResponseEntity<Void> deleteAssignmentById(String id);
    Assignment updateAssignment(Assignment assignment);
}
