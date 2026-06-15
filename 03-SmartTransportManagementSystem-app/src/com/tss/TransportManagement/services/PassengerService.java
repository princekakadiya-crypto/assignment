package com.tss.TransportManagement.services;

import com.tss.TransportManagement.Validation.InputValidation;
import com.tss.TransportManagement.exception.PassengerNotFoundException;
import com.tss.TransportManagement.models.Passenger;
import com.tss.TransportManagement.repository.PassengerRepository;

import java.util.ArrayList;
import java.util.List;

public class PassengerService {
    PassengerRepository passengerRepository=new PassengerRepository();
    public void addPassenger()
    {
        String name= InputValidation.readName("Enter Passenger Name : ");
        int age=InputValidation.readInt("Enter Age : ",0,"Age must be positive");
        Passenger passenger=passengerRepository.addPassenger(new Passenger(name,age));
        System.out.println("Passenger added with PassengerID : "+passenger.getPassengerId());
    }
    public void displayAllPassenger()
    {
        ArrayList<Passenger> passengers=passengerRepository.getAllPassenger();
        if (passengers.isEmpty())
        {
            System.out.println("No passenger found");
            return;
        }
        System.out.printf("%14s %15s %10s%n","PassengerID","Name","Age");
        System.out.println("---------------------------------------------------");
        for (Passenger passenger:passengers)
            passenger.displayPassenger();
    }
    public void displayPassengerByID(int passengerID)
    {
        Passenger passenger=passengerRepository.searchPassengerByID(passengerID);
        try {
            if (passenger==null)
                throw new PassengerNotFoundException(passengerID);
            System.out.println(passenger);
        } catch (PassengerNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
