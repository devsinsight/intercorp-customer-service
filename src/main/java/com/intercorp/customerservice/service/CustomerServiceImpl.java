package com.intercorp.customerservice.service;

import com.intercorp.customerservice.model.Customer;
import com.intercorp.customerservice.repository.CustomerRepository;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import java.util.List;

@Component
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private StandardDeviation standardDeviation;

    @Autowired
    private Mean mean;

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customer.createProbableDeathAge();
        customerRepository.save(customer);
    }

    @Override
    public double getClientsAgeStandardDeviation() {
        double[] customerAges = customerRepository.findAll().stream()
                .mapToDouble(Customer::getAge)
                .toArray();

        return standardDeviation.evaluate(customerAges);
    }

    @Override
    public double getClientsAgeMean() {
        double[] customerAges = customerRepository.findAll().stream()
                .mapToDouble(Customer::getAge)
                .toArray();

        return mean.evaluate(customerAges);
    }


}
