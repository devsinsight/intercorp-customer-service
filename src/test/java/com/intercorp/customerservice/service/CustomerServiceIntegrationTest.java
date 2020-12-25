package com.intercorp.customerservice.service;

import com.intercorp.customerservice.CustomerServiceApplicationTests;
import com.intercorp.customerservice.model.Customer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class CustomerServiceIntegrationTest extends CustomerServiceApplicationTests {

    @Autowired
    private CustomerService customerService;

    @Test
    public void whenFourUser_getStandardDeviation() {
        customerService.save(new Customer("Robert", "Smith", 31, LocalDate.of(1959  ,4,21)));
        customerService.save(new Customer("John", "Doe", 32, LocalDate.of(1984,7,23)));
        customerService.save(new Customer("Marty", "Friedman", 33, LocalDate.of(1962,12,8)));
        customerService.save(new Customer("Dave", "Mustaine", 45, LocalDate.of(1961,9,13)));
        double ds = customerService.getClientsAgeStandardDeviation();

        assertThat(ds).isEqualTo(6.551081335677848);
    }

    @Test
    public void whenFourUser_getMean() {
        customerService.save(new Customer("Robert", "Smith", 31, LocalDate.of(1959  ,4,21)));
        customerService.save(new Customer("John", "Doe", 32, LocalDate.of(1984,7,23)));
        customerService.save(new Customer("Marty", "Friedman", 33, LocalDate.of(1962,12,8)));
        customerService.save(new Customer("Dave", "Mustaine", 45, LocalDate.of(1961,9,13)));
        double mean = customerService.getClientsAgeMean();

        assertThat(mean).isEqualTo(35.25);
    }
}
