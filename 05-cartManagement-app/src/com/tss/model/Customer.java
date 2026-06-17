package com.tss.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private static long idCount=1;
    private long id;
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.id=idCount++;
        this.name = name;
        orders=new ArrayList<>();
    }

    public static long getIdCount() {
        return idCount;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Order> getOrders() {
        return orders;
    }
    public void addOrder(Order order)
    {
        orders.add(order);
    }
}
