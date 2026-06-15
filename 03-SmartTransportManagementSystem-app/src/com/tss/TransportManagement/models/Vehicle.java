package com.tss.TransportManagement.models;

import java.util.ArrayList;

public abstract class Vehicle {
    private static int countVehicleID=1001;
    private int vehicleID;
    private String vehicleNumber;
    private String driverName;
    private int capacity;
    private double totalRevenue;
    private int passengerCount;

    public Vehicle(String vehicleNumber, String driverName, int capacity) {
        this.vehicleID = countVehicleID++;
        this.vehicleNumber = vehicleNumber;
        this.driverName = driverName;
        this.capacity = capacity;
        totalRevenue=0;
        passengerCount=0;
    }
    public abstract void displayVehicle();
    public abstract double calculateFare(double distance);
    public int getAvailableSet()
    {
        return capacity-passengerCount;
    }
    public int getOccupancy()
    {
        return passengerCount;
    }
    public void updateRevenue(double revenue)
    {
        totalRevenue+=revenue;
    }
    public void increasePassengerCount()
    {
        passengerCount++;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

}
