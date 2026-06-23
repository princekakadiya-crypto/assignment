package com.tss.notification.velidation;

import com.tss.notification.model.NotificationRequest;

public class NotificationValidation {
    public static void validate(NotificationRequest request){
        if (request.getCustomerName()==null || request.getCustomerName().isEmpty())
            throw new IllegalArgumentException("Customer name can not be empty");
        if (request.getContactDetail()==null || request.getContactDetail().isEmpty())
            throw new IllegalArgumentException("Contact detail is required");
        if (request.getMessageContent() == null || request.getMessageContent().trim().isEmpty())
            throw new IllegalArgumentException("Message content cannot be empty");
    }
}
