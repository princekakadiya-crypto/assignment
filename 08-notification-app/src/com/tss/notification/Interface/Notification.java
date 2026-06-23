package com.tss.notification.Interface;

import com.tss.notification.model.NotificationRequest;

public interface Notification {
    String send(NotificationRequest notificationRequest);
}
