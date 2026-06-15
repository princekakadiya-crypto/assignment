package com.tss.TransportManagement.exception;

public class PassengerFullException extends RuntimeException{

    public String getMessage()
    {
        return "Vehicle capacity is full.";
    }
}
