package com.tss.model;

public class CourseType {
    private String courseType;
    private double fee;

    public CourseType(String courseType, double fee) {
        this.courseType = courseType;
        this.fee = fee;
    }

    public String getCourseType() {
        return courseType;
    }

    public double getFee() {
        return fee;
    }
}
