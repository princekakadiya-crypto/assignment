package com.tss.model;

public class EnrolmentRequest {
    private Student student;
    private Course course;
    private boolean isScholarship;

    public EnrolmentRequest(Student student, Course course, boolean isScholarship) {
        this.student = student;
        this.course = course;
        this.isScholarship = isScholarship;
    }

    public boolean isScholarship() {
        return isScholarship;
    }

    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }
}
