package com.valros.ux.services.smartrash.services.impl;

import com.valros.ux.services.model.Notification;
import com.valros.ux.services.smartrash.models.dao.INotificationDao;
import com.valros.ux.services.smartrash.services.INotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class NotificationService implements INotificationService {

    @Autowired
    private INotificationDao notificationDao;

    @Override
    public Notification getNotificationById(String id) {
        return notificationDao.getNotificationById(id);
    }

    @Override
    public List<Notification> getAllNotifications() {
        return notificationDao.getAllNotifications();
    }

    @Override
    public Notification createNotification(Notification notification) {
        return notificationDao.createNotification(notification);
    }

    @Override
    public ResponseEntity<Void> deleteNotificationById(String id) {
        return notificationDao.deleteNotificationById(id);
    }

    @Override
    public Notification updateNotification(Notification notification) {
        return notificationDao.updateNotification(notification);
    }
}
