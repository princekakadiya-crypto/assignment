package com.tss.services;

import com.tss.model.Course;
import com.tss.model.Student;
import com.tss.validation.StudentValidator;

public class EnrolmentRequest {
    StudentValidator studentValidator=new StudentValidator();
    public void requestForEnrolment()
    {
        Student student=new Student("prince","prince@gmail.com",21);
        studentValidator.validate(student);

    }
}
