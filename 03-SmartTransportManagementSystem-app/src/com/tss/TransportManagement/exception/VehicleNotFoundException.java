package com.tss.TransportManagement.exception;

public class VehicleNotFoundException extends RuntimeException{
    private int id;

    public VehicleNotFoundException(int id) {
        this.id = id;
    }
    public String getMessage()
    {
        return "Vehicle id "+id+" Not Found.";
    }
}
