package com.tss.notification.service;

import com.tss.notification.Interface.Notification;

public class NotificationService {
    public static Notification getNotification(String type)
    {
        switch (type.toLowerCase())
        {
            case "email":
                return new EmailNotification();
            case "sms":
                return new SmsNotification();
            case "push":
                return new PushNotification();
            case "whatsapp":
                return new WhatsAppNotification();
            default:
                return new UnsupportedNotification();
        }
    }
}
