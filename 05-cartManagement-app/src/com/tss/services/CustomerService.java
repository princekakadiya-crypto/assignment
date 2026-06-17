package com.tss.services;

import com.tss.Validation.InputValidation;
import com.tss.model.Customer;
import com.tss.repository.CustomerRepository;

public class CustomerService {
    CustomerRepository customerRepository=new CustomerRepository();
    public void addCustomer()
    {
        String name= InputValidation.readName("Enter Name : ");
        Customer customer= customerRepository.addCustomer(new Customer(name));
        System.out.println("Account created with id : "+customer.getId());
    }
    public Customer login()
    {
        long id=InputValidation.readLong("Enter Customer Id : ");
        return customerRepository.getCustomerById(id);
    }
}
