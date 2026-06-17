package com.tss.repository;

import com.tss.model.Customer;
import com.tss.model.Order;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private static List<Customer> customers=new ArrayList<>();
    public Customer addCustomer(Customer customer)
    {
        customers.add(customer);
        return customer;
    }
    public Customer getCustomerById(long id)
    {
        for (Customer customer:customers)
        {
            if (customer.getId()==id)
                return customer;
        }
        return null;
    }
}
