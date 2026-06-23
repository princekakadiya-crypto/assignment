package com.tss.solution.test;

import com.tss.solution.model.AlertSender;
import com.tss.solution.model.EmailAlertSender;
import com.tss.solution.model.EmergencyAlertService;
import com.tss.solution.model.SmsAlertSender;

public class EmergencyTest {
    public static void main(String[] args) {
        AlertSender alertSender=new EmailAlertSender();
        EmergencyAlertService emergencyAlertService=new EmergencyAlertService(alertSender);

        emergencyAlertService.sendEmergencyAlert("abc@gmail.com","emergency Message");

        AlertSender alertSender1=new SmsAlertSender();
        EmergencyAlertService emergencyAlertService1=new EmergencyAlertService(alertSender1);
        emergencyAlertService1.sendEmergencyAlert("1234567890","emergency message");
    }
}
