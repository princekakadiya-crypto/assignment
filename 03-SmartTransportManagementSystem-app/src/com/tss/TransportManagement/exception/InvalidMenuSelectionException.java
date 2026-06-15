package com.tss.TransportManagement.exception;

public class InvalidMenuSelectionException extends RuntimeException{
    private int choice;

    public InvalidMenuSelectionException(int choice) {
        this.choice = choice;
    }
    public String getMessage()
    {
        return "Invalid Choice. you entered : "+choice;
    }
}
