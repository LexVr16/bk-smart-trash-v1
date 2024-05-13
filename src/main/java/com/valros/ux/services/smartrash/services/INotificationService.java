package com.valros.ux.services.smartrash.services;

import com.valros.ux.services.model.Notification;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface INotificationService {

    Notification getNotificationById(String id);
    List<Notification> getAllNotifications();
    Notification createNotification(Notification notification);
    ResponseEntity<Void> deleteNotificationById(String id);
    Notification updateNotification(Notification notification);
    Integer postSendNotification(String communityId, Notification notification);
}
