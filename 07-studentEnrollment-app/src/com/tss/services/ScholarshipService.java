package com.tss.services;

public class ScholarshipService {
    public double applyDiscount(double fee,boolean isScholarship)
    {
        if (isScholarship==true)
            return fee*0.8;
        return fee;
    }
}
