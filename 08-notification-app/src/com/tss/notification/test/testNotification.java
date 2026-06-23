package com.tss.notification.test;

import com.tss.notification.model.NotificationRequest;
import com.tss.notification.service.NotificationProcessed;

public class testNotification {
    public static void main(String[] args) {
        NotificationProcessed notificationProcessed=new NotificationProcessed();
        NotificationRequest notificationRequest=new NotificationRequest("Prince","1234567890","sms","order placed","Your order has placed successfully","High","2026-06-19");
        notificationProcessed.send(notificationRequest);
    }
}
