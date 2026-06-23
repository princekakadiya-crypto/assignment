package com.tss.model;


import java.time.LocalDate;

public class Enrollment {
    private String enrollmentId;
    private Student student;
    private Course course;
    private double fee;
    private String date;

    public Enrollment(String enrollmentId, Student student, Course course, double fee) {
        this.enrollmentId = enrollmentId;
        this.student = student;
        this.course = course;
        this.fee = fee;
        this.date = LocalDate.now().toString();
    }

    public String getEnrollmentId() {
        return enrollmentId;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public double getFee() {
        return fee;
    }

    public String getDate() {
        return date;
    }
}
