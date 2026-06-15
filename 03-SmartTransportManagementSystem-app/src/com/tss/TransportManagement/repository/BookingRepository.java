package com.tss.TransportManagement.repository;

import com.tss.TransportManagement.models.Booking;

import java.util.ArrayList;
import java.util.List;

public class BookingRepository {
    private static List<Booking> bookings=new ArrayList<>();

    public List<Booking> getAllBookings() {
        return bookings;
    }

    public Booking addBooking(Booking booking) {
        bookings.add(booking);
        return booking;
    }

    public List<Booking> getBookingsByVehicleId(int vehicleId)
    {
        List<Booking> bookingsOfVehicle=new ArrayList<>();

        for (Booking booking:bookings)
        {
            if (booking.getVehicleId()==vehicleId)
                bookingsOfVehicle.add(booking);
        }
        return bookingsOfVehicle;
    }
}
