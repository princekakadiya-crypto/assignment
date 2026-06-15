package com.tss.TransportManagement.exception;

public class PassengerNotFoundException extends RuntimeException{
    private int id;

    public PassengerNotFoundException(int id) {
        this.id = id;
    }
    public String getMessage()
    {
        return "Passenger id "+id+" Not Found.";
    }
}
