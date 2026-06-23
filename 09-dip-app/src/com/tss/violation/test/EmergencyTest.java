package com.tss.violation.test;

import com.tss.violation.model.EmergencyAlertService;

public class EmergencyTest {
    public static void main(String[] args) {
        EmergencyAlertService emergencyAlertService=new EmergencyAlertService();
        emergencyAlertService.sendEmergencyAlert("abc@gmail.com","Emergency message");
    }
}
