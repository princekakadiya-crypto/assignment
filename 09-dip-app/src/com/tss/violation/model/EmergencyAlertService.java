package com.tss.violation.model;

public class EmergencyAlertService {
    EmailAlertSender emailAlertSender=new EmailAlertSender();

    public void sendEmergencyAlert(String recipient,String message)
    {
        emailAlertSender.sendEmail(recipient,message);
    }
}
