package com.tss.TransportManagement.services;

import com.tss.TransportManagement.Validation.InputValidation;
import com.tss.TransportManagement.exception.InvalidTravelDistanceException;
import com.tss.TransportManagement.exception.PassengerNotFoundException;
import com.tss.TransportManagement.exception.VehicleNotFoundException;
import com.tss.TransportManagement.models.Booking;
import com.tss.TransportManagement.models.Passenger;
import com.tss.TransportManagement.models.Vehicle;
import com.tss.TransportManagement.repository.BookingRepository;
import com.tss.TransportManagement.repository.PassengerRepository;
import com.tss.TransportManagement.repository.VehicleRepository;

import java.util.List;

public class BookingService {
    VehicleRepository vehicleRepository=new VehicleRepository();
    PassengerRepository passengerRepository=new PassengerRepository();
    BookingRepository bookingRepository=new BookingRepository();
    public void addBooking()
    {
        try {
            int vehicleId = InputValidation.readInt("Enter Vehicle ID : ");
            Vehicle vehicle = vehicleRepository.searchVehicleByID(vehicleId);
            if (vehicle==null)
                throw new VehicleNotFoundException(vehicleId);
            if (vehicle.getAvailableSet()==0)
            {
                System.out.println("Seat is Not Available in this Vehicle.");
                return;
            }

            int passengerId=InputValidation.readInt("Enter Passenger ID : ");
            Passenger passenger=passengerRepository.searchPassengerByID(passengerId);
            if (passenger==null)
                throw new PassengerNotFoundException(passengerId);

            String destination=InputValidation.readString("Enter Destination : ",3,50,"Destination length must be 3 to 50");
            double distance=InputValidation.readDouble("Enter Distance : ");
            if (distance<0)
                throw new InvalidTravelDistanceException(distance);
            double fare=vehicle.calculateFare(distance);

            Booking booking= bookingRepository.addBooking(new Booking(passenger,vehicle,destination,distance,fare));
            vehicle.updateRevenue(fare);
            vehicle.increasePassengerCount();
            System.out.println("Booking is confirm with booking ID : "+booking.getBookingId());
        }
        catch (VehicleNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        catch (PassengerNotFoundException e)
        {
            System.out.println(e.getMessage());
        } catch (InvalidTravelDistanceException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void displayBookingOfVehicle(int vehicleId)
    {
        List<Booking> bookings=bookingRepository.getBookingsByVehicleId(vehicleId);
        if (bookings.isEmpty())
        {
            System.out.println("No Booking Found");
            return;
        }
        System.out.printf("%10s %12s %15S %15s %15s %20s %15s %10s %10s%n","BookingID","VehicleID","Vehicle Number","Driver Name","PassengerId","Passenger Name","Destination","Distance","Fare");
        System.out.println("----------------------------------------------------------------------------------------------");
        for (Booking booking:bookings)
        {
            System.out.printf("%10d %12d %15S %15s %15d %20s %15s %10.2f %10f%n",booking.getBookingId(),booking.getVehicleId(),booking.getVehicleNumber(),booking.getDriverName(),booking.getPassengerId(),booking.getPassengerName(),booking.getDestination(),booking.getDistance(),booking.getFare());
        }
    }
    public void displayAvailableSeatOfVehicle(int vehicleId)
    {
        int availableSet=vehicleRepository.getVehicleAvailableSeat(vehicleId);
        try
        {
            if (availableSet==-1)
                throw new VehicleNotFoundException(vehicleId);
            System.out.println("Available Seats Are : "+availableSet);
        }
        catch (VehicleNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
