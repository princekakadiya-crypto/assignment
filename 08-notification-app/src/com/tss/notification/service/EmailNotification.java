package com.tss.notification.service;

import com.tss.notification.Interface.Notification;
import com.tss.notification.model.NotificationRequest;

public class EmailNotification implements Notification {
    @Override
    public String send(NotificationRequest notificationRequest) {
        String message="Email : "+notificationRequest.getCustomerName()+"\n"+notificationRequest.getMessageContent();
        return message;
    }
}
