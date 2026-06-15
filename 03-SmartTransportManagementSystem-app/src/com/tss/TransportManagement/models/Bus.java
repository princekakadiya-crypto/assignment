package com.tss.TransportManagement.models;

import com.tss.TransportManagement.Interface.Maintainable;

public class Bus extends Vehicle implements Maintainable {
    private static final int MAX_CAPACITY = 50;
    private double farePerKm;
    private boolean underMaintenance;
    public Bus( String vehicleNumber, String driverName, int capacity,double farePerKm) {
        super( vehicleNumber, driverName, capacity);
        this.farePerKm=farePerKm;
        this.underMaintenance = false;
    }

    @Override
    public void displayVehicle() {
        System.out.printf("%-10d %-16s %-15s %-15s %-10d %-15.2f %-15s%n",getVehicleID(),getVehicleNumber(),getDriverName(),"Bus",getCapacity(),farePerKm,"-");
    }

    @Override
    public String toString() {
        return "\nvehicle ID : "+getVehicleID()+
                "\nVehicle Number : "+getVehicleNumber()+
                "\nDriver Name : "+getDriverName()+
                "\nVehicle Type : Bus"+
                "\nCapacity : "+getCapacity()+
                "\nFare Per KM "+farePerKm+
                "\nunderMaintenance=" + (underMaintenance?"Yes":"No")
                ;
    }

    @Override
    public double calculateFare(double distance) {
        return distance*farePerKm;
    }

    public void setUnderMaintenance(boolean flag)
    {
        underMaintenance=flag;
    }

    public double getFarePerKm() {
        return farePerKm;
    }

    public boolean isUnderMaintenance() {
        return underMaintenance;
    }
    public static int getMaxCapacity()
    {
        return MAX_CAPACITY;
    }

    @Override
    public void setVehicleUnderMaintenance() {
        underMaintenance=true;
    }

    @Override
    public void completeMaintenance() {
        underMaintenance=false;
    }

    @Override
    public boolean chackMaintenanceStatus() {
        return underMaintenance;
    }
}
