package com.valros.ux.services.smartrash.models.dao.impl;

import com.valros.ux.services.model.Assignment;
import com.valros.ux.services.smartrash.models.dao.IAssignmentDao;
import com.valros.ux.services.smartrash.repositories.IAssignmentRepository;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class AssignmentDao implements IAssignmentDao {

    @Autowired
    private IAssignmentRepository assignmentRepository;

    @Override
    public Assignment getAssignmentById(String id) {
        try {
            log.info("<<< In progress... - getAssignmentById()");
            Optional<Assignment> assignmentOptional = assignmentRepository.findById(Integer.parseInt(id));
            if (assignmentOptional.isPresent()) {
                log.info("Complete - getAssignmentById() >>>");
                return assignmentOptional.get();
            }
            throw new NotFoundException("throw new NotFoundException - getAssignmentById()");
        } catch (Throwable e) {
            log.error("Error getTrukById(): " + e.getCause().getCause().getMessage());
            throw new RuntimeException("throw new RuntimeException - getAssignmentById()",e);
        }
    }

    @Override
    public List<Assignment> getAllAssignments() {
        try {
            log.info("<<< In progress... - getAllAssignments()");
            List<Assignment> assignmentList = assignmentRepository.findAll();
            log.info("Complete - getAllAssignments() >>>");
            return assignmentList;
        } catch (Exception e) {
            log.error("Error getAllAssignments(): " + e.getCause().getCause().getMessage());
            throw new RuntimeException("throw new RuntimeException - getAllAssignments()", e);
        }
    }

    @Override
    public Assignment createAssignment(Assignment assignment) {
        try {
            log.info("<<< In progress... - createAssignment()");
            Assignment objAssignment = new Assignment();
            objAssignment.setUserId(assignment.getUserId());
            objAssignment.setTrukId(assignment.getTrukId());
            objAssignment.setCommunityId(assignment.getCommunityId());
            objAssignment.setAssignmentDate(assignment.getAssignmentDate());
            objAssignment.setAssignmentHour(assignment.getAssignmentHour());
            assignmentRepository.save(objAssignment);
            log.info("Complete - createAssignment() >>>");
            return objAssignment;
        } catch (Exception e) {
            log.error("Error createAssignment(): " + e.getCause().getCause().getMessage());
            throw new RuntimeException("throw new RuntimeException - createAssignment()", e);
        }
    }

    @Override
    public ResponseEntity<Void> deleteAssignmentById(String id) {
        try {
            log.info("<<< In progress... - deleteAssignmentById()");
            assignmentRepository.deleteById(Integer.parseInt(id));
            log.info("Complete - deleteAssignmentById() >>>");
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.error("Error deleteUserById(): " + e.getCause().getCause().getMessage());
            throw new RuntimeException("throw new RuntimeException - deleteAssignmentById()", e);
        }
    }

    @Override
    public Assignment updateAssignment(Assignment assignment) {
        try {
            log.info("<<< In progress... - updateAssignment()");
            Optional<Assignment> existingAssignmentOptional = assignmentRepository.findById(assignment.getAssignmentId());

            if (existingAssignmentOptional.isPresent()) {
                Assignment existingAssignment = new Assignment();
                existingAssignment.setUserId(assignment.getUserId());
                existingAssignment.setTrukId(assignment.getTrukId());
                existingAssignment.setCommunityId(assignment.getCommunityId());
                existingAssignment.setAssignmentDate(assignment.getAssignmentDate());
                existingAssignment.setAssignmentHour(assignment.getAssignmentHour());

                Assignment updatedAssignment = assignmentRepository.save(existingAssignment);
                log.info("Complete - updateAssignment() >>>");
                return updatedAssignment;
            } else {
                log.info("ERROR - updateUser() >>>");
                throw new NotFoundException("throw new NotFoundException - updateAssignment()");
            }
        } catch (Exception e) {
            log.error("Error - updateAssignment(): " + e.getMessage());
            throw new RuntimeException("throw new RuntimeException - updateAssignment()", e);
        }
    }
}
