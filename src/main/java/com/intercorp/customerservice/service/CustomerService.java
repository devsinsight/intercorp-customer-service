package com.intercorp.customerservice.service;

import com.intercorp.customerservice.model.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getAll();
    public void save(Customer customer);
    public double getClientsAgeStandardDeviation();
    public double getClientsAgeMean();
}
