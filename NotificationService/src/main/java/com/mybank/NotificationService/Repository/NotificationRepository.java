package com.mybank.NotificationService.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.mybank.NotificationService.Model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface NotificationRepository extends JpaRepository<Notification,Long> {

}
