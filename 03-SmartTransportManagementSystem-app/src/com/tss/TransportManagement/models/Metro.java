package com.tss.TransportManagement.models;

import com.tss.TransportManagement.Interface.Maintainable;

public class Metro extends Vehicle implements Maintainable {
    private static final int MAX_CAPACITY = 500;
    private double farePerKm;
    private boolean underMaintenance;

    public Metro(String vehicleNumber, String driverName, int capacity, double farePerKm) {
        super(vehicleNumber, driverName, capacity);
        this.farePerKm = farePerKm;
        this.underMaintenance = false;
    }

    @Override
    public void displayVehicle() {
        System.out.printf("%-10d %-16s %-15s %-15s %-10d %-15.2f %-15s%n",getVehicleID(),getVehicleNumber(),getDriverName(),"Metro",getCapacity(),farePerKm,"-");
    }

    @Override
    public double calculateFare(double distance) {
        return distance*farePerKm;
    }

    public String toString() {
        return "\nvehicle ID : "+getVehicleID()+
                "\nVehicle Number : "+getVehicleNumber()+
                "\nDriver Name : "+getDriverName()+
                "\nVehicle Type : Metro"+
                "\nCapacity : "+getCapacity()+
                "\nFare Per KM "+farePerKm+
                "\nunderMaintenance=" + (underMaintenance?"Yes":"No")
                ;
    }

    public boolean isUnderMaintenance() {
        return underMaintenance;
    }

    public void setUnderMaintenance(boolean underMaintenance) {
        this.underMaintenance = underMaintenance;
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
