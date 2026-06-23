package com.tss.solution.model;

public class SmsAlertSender implements AlertSender{
    @Override
    public void sendAlert(String recipient, String message) {
        System.out.println("Mobile : "+recipient);
        System.out.println("Message : "+message);
        System.out.println("SMS send successfully");

    }
}
