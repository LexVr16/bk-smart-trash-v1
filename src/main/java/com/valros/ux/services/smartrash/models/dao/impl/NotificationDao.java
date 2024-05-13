package com.valros.ux.services.smartrash.models.dao.impl;

import com.valros.ux.services.model.Notification;
import com.valros.ux.services.smartrash.models.dao.INotificationDao;
import com.valros.ux.services.smartrash.repositories.INotificationRepository;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class NotificationDao implements INotificationDao {

    @Autowired
    private INotificationRepository iNotificationRepository;

    @Override
    public Notification getNotificationById(String id) {
        try {
            log.info("<<< In progress... - getNotificationById()");
            Optional<Notification> notificationOptional = iNotificationRepository.findById(Integer.parseInt(id));
            if (notificationOptional.isPresent()) {
                log.info("Complete - getNotificationById() >>>");
                return notificationOptional.get();
            }
            throw new NotFoundException("ERROR Notification no Encontrado - getNotificationById()");
        } catch (Throwable e) {
            log.error("Error getNotificationById(): " + e.getCause().getCause().getMessage());
            throw new RuntimeException("throw new RuntimeException - getNotificationById()",e);
        }
    }

    @Override
    public List<Notification> getAllNotifications() {
        try {
            log.info("<<< In progress... getAllNotifications()");
            List<Notification> notificationList = iNotificationRepository.findAll();
            log.info("Complete - getAllNotifications() >>>");
            return notificationList;
        } catch (Exception e) {
            log.error("Error  getAllNotifications(): " + e.getCause().getCause().getMessage());
            throw new RuntimeException("throw new RuntimeException - getNotificationById()",e);
        }
    }

    @Override
    public Notification createNotification(Notification notification) {
        try {
            log.info("<<< In progress... - createNotification()");
            Notification objNotification = new Notification();
            objNotification.setTrukId(notification.getTrukId());
            objNotification.setCommunityId(notification.getCommunityId());
            objNotification.setUserId(notification.getUserId());
            objNotification.setNotificationDate(notification.getNotificationDate());
            objNotification.setNotificationHour(notification.getNotificationHour());
            iNotificationRepository.save(objNotification);
            log.info("Complete - createNotification() >>>");
            return objNotification;
        } catch (Exception e) {
            log.error("Error createNotification(): " + e.getCause().getCause().getMessage());
            throw new RuntimeException("throw new RuntimeException - createNotification()", e);
        }
    }

    @Override
    public ResponseEntity<Void> deleteNotificationById(String id) {
        try {
            log.info("<<< In progress... - deleteNotificationById()");
            iNotificationRepository.deleteById(Integer.parseInt(id));
            log.info("Complete - deleteNotificationById() >>>");
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.error("Error deleteTrukById(): " + e.getCause().getCause().getMessage());
            throw new RuntimeException("throw new RuntimeException - deleteNotificationById()", e);
        }
    }

    @Override
    public Notification updateNotification(Notification notification) {
        try {
            log.info("<<< In progress... - updateNotification()");
            Optional<Notification> existingNotificationOptional = iNotificationRepository.findById(notification.getNotificationId());
            if (existingNotificationOptional.isPresent()) {
                Notification existingNotification = existingNotificationOptional.get();
                existingNotification.setTrukId(notification.getTrukId());
                existingNotification.setCommunityId(notification.getCommunityId());
                existingNotification.setUserId(notification.getUserId());
                existingNotification.setNotificationDate(notification.getNotificationDate());
                existingNotification.setNotificationHour(notification.getNotificationHour());
                Notification updatedNotification = iNotificationRepository.save(existingNotification);
                log.info("Complete - updateNotification() >>>");
                return updatedNotification;
            } else {
                log.info("ERROR - updateNotification() >>>");
                throw new NotFoundException("ERROR Notification no encontrado - updateNotification()");
            }
        } catch (Exception e) {
            log.error("Error - updateTruk(): " + e.getMessage());
            throw new RuntimeException("throw new RuntimeException - updateTruk()", e);
        }
    }
}
