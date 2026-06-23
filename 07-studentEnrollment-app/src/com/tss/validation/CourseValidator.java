package com.tss.validation;

import com.tss.model.Course;

public class CourseValidator {
    public void validate(Course course)
    {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null");
        }

        if (course.getCourseName() == null ||
                course.getCourseName().isBlank()) {
            throw new IllegalArgumentException("Course name is required");
        }

        if (course.getCourseType() == null) {
            throw new IllegalArgumentException("Course type is required");
        }

        if (course.getDuration() <= 0) {
            throw new IllegalArgumentException("Course duration must be greater than 0");
        }

        if (course.getAvailableSeats() < 0) {
            throw new IllegalArgumentException("Available seats cannot be negative");
        }
    }
}
