package com.tss.TransportManagement.exception;

public class VehicleOperationNotSupportException extends RuntimeException {
    public String getMessage()
    {
        return "the operation is not allowed in this vehicle.";
    }
}
