package com.tss.services;

import com.tss.model.Enrollment;
import com.tss.model.EnrolmentRequest;
import com.tss.repository.EnrollmentRepository;
import com.tss.validation.CourseValidator;
import com.tss.validation.StudentValidator;

public class EnrollmentService {
    StudentValidator studentValidator=new StudentValidator();
    CourseValidator courseValidator=new CourseValidator();
    SeatAvailability seatAvailability=new SeatAvailability();
    FeeCalculator feeCalculator=new FeeCalculator();
    ScholarshipService scholarshipService=new ScholarshipService();
    ConfirmationNumberGenerator confirmationNumberGenerator=new ConfirmationNumberGenerator();
    EnrollmentRepository enrollmentRepository=new EnrollmentRepository();
    NotificationService notificationService=new NotificationService();

    public void enroll(EnrolmentRequest request)
    {
        studentValidator.validate(request.getStudent());

        courseValidator.validate(request.getCourse());

        if(!seatAvailability.hasAvailableSeats(request.getCourse()))
            throw new RuntimeException("Seat Not Available");

        double fee = feeCalculator.calculateFee(request.getCourse());

        fee = scholarshipService.applyDiscount(fee, request.isScholarship());

        String enrollmentId = confirmationNumberGenerator.generate();

        Enrollment enrollment = new Enrollment(enrollmentId, request.getStudent(), request.getCourse(), fee);

        enrollmentRepository.save(enrollment);

        notificationService.sendNotification(enrollment);
    }
}
