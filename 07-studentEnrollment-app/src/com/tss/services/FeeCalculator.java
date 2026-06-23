package com.tss.services;

import com.tss.model.Course;

public class FeeCalculator {
    public double calculateFee(Course course)
    {
        return course.getCourseType().getFee();
    }
}
