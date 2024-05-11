package com.valros.ux.services.smartrash.services;

import com.valros.ux.services.model.Assignment;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IAssignmentService {

    Assignment getAssignmentById(String id);
    List<Assignment> getAllAssignments();
    Assignment createAssignment(Assignment assignment);
    ResponseEntity<Void> deleteAssignmentById(String id);
    Assignment updateAssignment(Assignment assignment);
}
