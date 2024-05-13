package com.valros.ux.services.smartrash.services.impl;

import com.valros.ux.services.model.Notification;
import com.valros.ux.services.model.User;
import com.valros.ux.services.smartrash.models.dao.INotificationDao;
import com.valros.ux.services.smartrash.models.dao.IUserDao;
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

    @Autowired
    private IUserDao iUserDao;

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

    @Override
    public Integer postSendNotification(String communityId, Notification notification) {
        List<User>  userList = iUserDao.getAllUsersByCommunityId(communityId);
        userList.forEach(user -> {
            notification.setCommunityId(Integer.parseInt(communityId));
            notification.setUserId(user.getUserId());
            this.createNotification(notification);
        });
        return (int) userList.stream().count();
    }
}
