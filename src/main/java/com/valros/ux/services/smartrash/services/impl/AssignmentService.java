package com.valros.ux.services.smartrash.services.impl;

import com.valros.ux.services.model.Assignment;
import com.valros.ux.services.smartrash.models.dao.IAssignmentDao;
import com.valros.ux.services.smartrash.services.IAssignmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AssignmentService implements IAssignmentService {

    @Autowired
    private IAssignmentDao iAssignmentDao;

    @Override
    public Assignment getAssignmentById(String id) {
        return iAssignmentDao.getAssignmentById(id);
    }

    @Override
    public List<Assignment> getAllAssignments() {
        return iAssignmentDao.getAllAssignments();
    }

    @Override
    public Assignment createAssignment(Assignment assignment) {
        return iAssignmentDao.createAssignment(assignment);
    }

    @Override
    public ResponseEntity<Void> deleteAssignmentById(String id) {
        return iAssignmentDao.deleteAssignmentById(id);
    }

    @Override
    public Assignment updateAssignment(Assignment assignment) {
        return iAssignmentDao.updateAssignment(assignment);
    }
}
