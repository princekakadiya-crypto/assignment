package com.tss.model;

public class Course {
    private String courseName;
    private CourseType courseType;
    private double duration;
    private int availableSeats;

    public Course(String courseName, CourseType courseType,double duration, int availableSeats) {
        this.courseName = courseName;
        this.courseType = courseType;
        this.duration = duration;
        this.availableSeats = availableSeats;
    }

    public String getCourseName() {
        return courseName;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public double getDuration() {
        return duration;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}
