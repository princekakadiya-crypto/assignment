package com.tss.TransportManagement.repository;

import com.tss.TransportManagement.models.Passenger;
import com.tss.TransportManagement.models.Vehicle;

import java.util.ArrayList;

public class PassengerRepository {
    private static ArrayList<Passenger> passengers=new ArrayList<>();

    public Passenger addPassenger(Passenger passenger)
    {
        passengers.add(passenger);
        return passenger;
    }

    public ArrayList<Passenger> getAllPassenger()
    {
        return passengers;
    }

    public Passenger searchPassengerByID(int passengerID)
    {
        for(Passenger passenger:passengers)
        {
            if (passenger.getPassengerId()==passengerID)
                return passenger;
        }
        return null;
    }
}
