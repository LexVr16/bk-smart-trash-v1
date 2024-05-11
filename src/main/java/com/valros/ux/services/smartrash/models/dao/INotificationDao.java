package com.valros.ux.services.smartrash.models.dao;

import com.valros.ux.services.model.Notification;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface INotificationDao {

    Notification getNotificationById(String id);
    List<Notification> getAllNotifications();
    Notification createNotification(Notification notification);
    ResponseEntity<Void> deleteNotificationById(String id);
    Notification updateNotification(Notification notification);
}
