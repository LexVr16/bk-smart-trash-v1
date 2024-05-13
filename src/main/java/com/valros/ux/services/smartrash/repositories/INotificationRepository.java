package com.valros.ux.services.smartrash.repositories;

import com.valros.ux.services.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INotificationRepository extends JpaRepository<Notification,Integer> {

}
