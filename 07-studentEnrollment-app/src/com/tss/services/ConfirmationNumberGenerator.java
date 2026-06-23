package com.tss.services;

public class ConfirmationNumberGenerator {
    private static long count=100;
    public String generate()
    {
        return "ENR"+count++;
    }
}
