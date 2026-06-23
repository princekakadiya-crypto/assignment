package com.tss.services;

import com.tss.model.Course;

public class SeatAvailability {
    public boolean hasAvailableSeats(Course course)
    {
        if (course.getAvailableSeats()>0)
            return true;
        return false;
    }
}
