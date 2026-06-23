package com.tss.test;

import com.tss.model.*;
import com.tss.services.EnrollmentService;

public class test {
    public static void main(String[] args) {
        CourseType courseTypeOnline=new CourseType("online",5000);
        CourseType courseTypeOffline=new CourseType("Offline",5000);

        Course course=new Course("MCA",courseTypeOffline,2,50);

        Student student=new Student("Prince","prince727@gmail.com",21);
        EnrolmentRequest enrolmentRequest=new EnrolmentRequest(student,course,true);

        EnrollmentService enrollmentService=new EnrollmentService();
        enrollmentService.enroll(enrolmentRequest);
    }
}
