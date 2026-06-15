package com.tss.TransportManagement.exception;

public class InvalidTravelDistanceException extends RuntimeException{
    private double distance;

    public InvalidTravelDistanceException(double distance) {
        this.distance = distance;
    }
    public String getMessage()
    {
        return "Invalid travel distance. You entered : "+distance;
    }
}
