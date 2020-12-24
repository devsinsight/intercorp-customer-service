package com.intercorp.customerservice.repository;

import com.intercorp.customerservice.model.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryIntegrationTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void whenCalledSave_thenCorrectNumberOfCustomers() {
        customerRepository.save(new Customer("Jose", "Olivares", 36, LocalDate.of(1984,7,23)));
        List<Customer> customers = (List<Customer>) customerRepository.findAll();

        assertThat(customers.size()).isEqualTo(1);
    }

}
