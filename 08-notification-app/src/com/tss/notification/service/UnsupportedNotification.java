package com.tss.notification.service;

import com.tss.notification.Interface.Notification;
import com.tss.notification.model.NotificationRequest;

public class UnsupportedNotification implements Notification {
    @Override
    public String send(NotificationRequest notificationRequest) {
        String message="Error : Unsupported Notification Type";
        return message;
    }
}
