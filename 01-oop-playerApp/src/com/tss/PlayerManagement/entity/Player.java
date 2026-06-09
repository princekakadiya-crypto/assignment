package com.tss.PlayerManagement.entity;

public class Player {

    private int id;
    private String name;
    private int numberOfMatchas;
    private int runs;
    private int wickets;

    public Player()
    {
        id=0;
        name="";
        numberOfMatchas=0;
        runs=0;
        wickets=0;
    }
    public Player(int id,String name,int numberOfMatchas,int runs,int wickets)
    {
        this.id=id;
        this.name=name;
        this.numberOfMatchas=numberOfMatchas;
        this.runs=runs;
        this.wickets=wickets;
    }

    public int getId() {
        return id;
    }

    public int getNumberOfMatchas() {
        return numberOfMatchas;
    }

    public int getRuns() {
        return runs;
    }

    public int getWickets() {
        return wickets;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfMatchas(int numberOfMatchas) {
        this.numberOfMatchas = numberOfMatchas;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public double calculateAverage()
    {
        return (double)(runs/numberOfMatchas);
    }

    public void printDetails()
    {
        System.out.println("ID : "+id);
        System.out.println("Name : "+name);
        System.out.println("Number Of Matches : "+numberOfMatchas);
        System.out.println("Runs : "+runs);
        System.out.println("Wicket : "+wickets);
        System.out.println("Batting Average : "+ calculateAverage());
    }
}

