package com.tss.TransportManagement.models;

public class Booking {
    private static int bookingCount=1;
    private int bookingId;
    private Passenger passenger;
    private Vehicle vehicle;
    private String destination;
    private double distance;
    private double fare;

    public Booking(Passenger passenger, Vehicle vehicle,String destination, double distance, double fare) {
        bookingId=bookingCount++;
        this.passenger = passenger;
        this.vehicle = vehicle;
        this.destination=destination;
        this.distance = distance;
        this.fare = fare;
    }

    public void display()
    {
        System.out.println("Booking ID : "+bookingId);
        System.out.println("Passenger Name : "+passenger.getPassengerName());
        System.out.println("Vehicle Number : "+vehicle.getVehicleNumber());
        System.out.println("Distance : "+distance);
        System.out.println("Fare : "+fare);
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getVehicleId()
    {
        return vehicle.getVehicleID();
    }
    public String getVehicleNumber()
    {
        return vehicle.getVehicleNumber();
    }
    public String getDriverName()
    {
        return vehicle.getDriverName();
    }
    public int getPassengerId()
    {
        return passenger.getPassengerId();
    }
    public String getPassengerName()
    {
        return passenger.getPassengerName();
    }

    public String getDestination() {
        return destination;
    }

    public int getAvailableSeat()
    {
        return getAvailableSeat();
    }

    public double getDistance() {
        return distance;
    }

    public double getFare() {
        return fare;
    }
}
