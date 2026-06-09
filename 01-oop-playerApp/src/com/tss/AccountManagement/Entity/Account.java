package com.tss.AccountManagement.Entity;

import java.util.Random;

public class Account {
    private static int count=1;
    private int id=0;
    private String accountNumber;
    private String name;
    private double balance;
    private String accountType;
    public Account()
    {
        id=count++;
        accountNumber=generateAccountNumber();
        name="";
        balance=500;
        accountType="";
    }
    public Account(String name,double balance,String accountType)
    {
        id=count++;
        accountNumber=generateAccountNumber();
        this.name=name;
        this.balance=balance;
        this.accountType=accountType;
    }
    private String generateAccountNumber()
    {
        Random random = new Random();

        int eighthDigitNumber = random.nextInt(90000000) + 10000000;
        return Integer.toString(eighthDigitNumber);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public void deposit(double amount)
    {
        balance+=amount;
    }
    public boolean withdraw(double amount)
    {
        if((balance-amount)<500)
        {
            System.out.println("Minimum 500 Balance Required.");
            return false;
        }
        else
        {
            balance-=amount;
            return true;
        }
    }
    public int getID()
    {
        return id;
    }

    public void printDetail()
    {
        System.out.println("ID : "+id);
        System.out.println("Name : "+name);
        System.out.println("Balance : "+balance);
        System.out.println("Account Number : "+accountNumber);
        System.out.println("Account Type : "+accountType);
    }
}
