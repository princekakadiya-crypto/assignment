package com.tss.TransportManagement.models;

public class Passenger {
    private static int idCount=1;
    private int passengerId;
    private String name;
    private int age;

    public Passenger(String name, int age) {
        this.passengerId = idCount++;
        this.name = name;
        this.age = age;
    }
    public void displayPassenger()
    {
        System.out.printf("%14d %15s %10d%n",passengerId,name,age);
    }

    @Override
    public String toString() {
        return  "\npassengerId : " + passengerId +
                "\nname : " + name +
                "\nage : " + age
                ;
    }

    public int getPassengerId() {
        return passengerId;
    }


    public int getAge() {
        return age;
    }

    public String getPassengerName()
    {
        return name;
    }
}
