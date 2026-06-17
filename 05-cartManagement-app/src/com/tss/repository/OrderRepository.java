package com.tss.repository;

import com.tss.model.Customer;
import com.tss.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private static List<Order> orders;
    private static Customer customer=null;
    public void setOrders(Customer customer)
    {
        if (customer.getOrders().isEmpty())
            orders=new ArrayList<>();
        else
            orders=customer.getOrders();
        OrderRepository.customer=customer;
    }
    public List<Order> getOrders()
    {
        return orders;
    }
    public void addOrderInCustomer(Order order)
    {
        customer.addOrder(order);
        orders.add(order);
    }
}
