package com.valros.ux.services.smartrash.controllers;

import com.valros.ux.services.controller.AssignmentsApi;
import com.valros.ux.services.model.Assignment;
import com.valros.ux.services.smartrash.services.IAssignmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("${application.api.base-path}")
public class AssignmentController implements AssignmentsApi {

    @Autowired
    private IAssignmentService iAssignmentService;


    @Override
    public ResponseEntity<Void> assignmentDeleteById(String assignmentId) {
        try {
            return iAssignmentService.deleteAssignmentById(assignmentId);
        } catch (Exception e) {
            log.error("Error retrieving assignmentDeleteById", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Assignment> assignmentUpdateById(String assignmentId, Assignment assignment) {
        try {
            return ResponseEntity.ok(iAssignmentService.updateAssignment(assignment));
        } catch (Exception e) {
            log.error("Error retrieving assignmentUpdateById", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Assignment> getAssignmentById(String assignmentId) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(iAssignmentService.getAssignmentById(assignmentId));
        } catch (Exception e) {
            log.error("Error retrieving getAssignmentById", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<List<Assignment>> getAllAssignments() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(iAssignmentService.getAllAssignments());
        } catch (Exception e) {
            log.error("Error retrieving getAllAssignments", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Assignment> postCreateAssignments(Assignment assignment) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(iAssignmentService.createAssignment(assignment));
        } catch (Exception e) {
            log.error("Error retrieving postCreateAssignments", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
