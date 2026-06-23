package com.tss.solution.model;

public class EmergencyAlertService {
    AlertSender alertSender;
    public EmergencyAlertService(AlertSender alertSender) {
        this.alertSender=alertSender;
    }

    public void sendEmergencyAlert(String recipient, String message)
    {
        alertSender.sendAlert(recipient,message);
    }
}
