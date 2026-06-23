package com.tss.solution.model;

public class EmailAlertSender implements AlertSender {

    @Override
    public void sendAlert(String recipient, String message) {
        System.out.println("Email : "+recipient);
        System.out.println("Message : "+message);
        System.out.println("Mail send successfully");
    }
}
