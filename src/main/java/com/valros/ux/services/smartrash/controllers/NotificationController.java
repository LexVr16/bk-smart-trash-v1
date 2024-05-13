package com.valros.ux.services.smartrash.controllers;

import com.valros.ux.services.controller.NotificationsApi;
import com.valros.ux.services.model.Notification;
import com.valros.ux.services.model.User;
import com.valros.ux.services.smartrash.services.INotificationService;
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
public class NotificationController implements NotificationsApi {

    @Autowired
    private INotificationService iNotificationService;

    @Override
    public ResponseEntity<Notification> getNotificationById(String notificationId) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(iNotificationService.getNotificationById(notificationId));
        } catch (Exception e) {
            log.error("Error retrieving getNotificationById", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<List<Notification>> getAllNotifications() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(iNotificationService.getAllNotifications());
        } catch (Exception e) {
            log.error("Error retrieving getAllNotifications", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Void> notificationDeleteById(String notificationId) {
        try {
            return iNotificationService.deleteNotificationById(notificationId);
        } catch (Exception e) {
            log.error("Error retrieving notificationDeleteById", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Notification> notificationUpdateById(String notificationId, Notification notification) {
        try {
            return ResponseEntity.ok(iNotificationService.updateNotification(notification));
        } catch (Exception e) {
            log.error("Error retrieving notificationUpdateById", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Notification> postCreateNotification(Notification notification) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(iNotificationService.createNotification(notification));
        } catch (Exception e) {
            log.error("Error retrieving postCreateNotification", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Integer> postSendNotification(String communityId, Notification notification) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(iNotificationService.postSendNotification(communityId, notification));
        } catch (Exception e) {
            log.error("Error retrieving postCreateNotification", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
