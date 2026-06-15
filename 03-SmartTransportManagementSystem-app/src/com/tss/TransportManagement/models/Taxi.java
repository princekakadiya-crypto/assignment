package com.tss.TransportManagement.models;

public class Taxi extends Vehicle{
    private static final int MAX_CAPACITY = 4;
    private double baseFare;
    private double farePerKm;

    public Taxi(String vehicleNumber, String driverName, int capacity, double baseFare, double farePerKm) {
        super(vehicleNumber, driverName, capacity);
        this.baseFare = baseFare;
        this.farePerKm = farePerKm;
    }

    @Override
    public void displayVehicle() {
        System.out.printf("%-10d %-16s %-15s %-15s %-10d %-15.2f %-15.2f%n",getVehicleID(),getVehicleNumber(),getDriverName(),"Taxi",getCapacity(),farePerKm,baseFare);
    }

    @Override
    public double calculateFare(double distance) {
        return baseFare+(distance*farePerKm);
    }
    public static int getMaxCapacity()
    {
        return MAX_CAPACITY;
    }

    public String toString() {
        return "\nvehicle ID : "+getVehicleID()+
                "\nVehicle Number : "+getVehicleNumber()+
                "\nDriver Name : "+getDriverName()+
                "\nVehicle Type : Bus"+
                "\nCapacity : "+getCapacity()+
                "\nFare Per KM "+farePerKm+
                "\nBase Fare=" + baseFare
                ;
    }
}
