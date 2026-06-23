package com.tss.notification.service;

import com.tss.notification.Interface.Notification;
import com.tss.notification.model.NotificationRequest;
import com.tss.notification.velidation.NotificationValidation;

public class NotificationProcessed {
    public void send(NotificationRequest notificationRequest)
    {
        NotificationValidation.validate(notificationRequest);

        Notification notification=NotificationService.getNotification(notificationRequest.getNotificationType());

        System.out.println(notification.send(notificationRequest));
    }
}
