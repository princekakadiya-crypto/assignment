package com.tss.validation;

import com.tss.model.Student;

public class StudentValidator {
    public void validate(Student student)
    {
        if (student.getName()==null || student.getName().isEmpty())
            throw new IllegalArgumentException("Name can not be null");
        if (student.getEmail()==null || !student.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
            throw new IllegalArgumentException("Invalid Email");
        if (student.getAge()<16)
            throw new IllegalArgumentException("Age should not be less then 16");
    }
}
