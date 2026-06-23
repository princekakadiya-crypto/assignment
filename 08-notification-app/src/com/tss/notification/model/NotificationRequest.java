package com.tss.notification.model;

public class NotificationRequest {
    private String customerName;
    private String contactDetail;
    private String notificationType;
    private String eventType;
    private String messageContent;
    private String priorityLevel;
    private String timestamp;

    public NotificationRequest(String customerName, String contactDetail, String notificationType, String eventType, String messageContent, String priorityLevel, String timestamp) {
        this.customerName = customerName;
        this.contactDetail = contactDetail;
        this.notificationType = notificationType;
        this.eventType = eventType;
        this.messageContent = messageContent;
        this.priorityLevel = priorityLevel;
        this.timestamp = timestamp;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getContactDetail() {
        return contactDetail;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public String getEventType() {
        return eventType;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public String getPriorityLevel() {
        return priorityLevel;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
