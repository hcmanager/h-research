package com.hc.research.service;

import com.hc.research.domain.Customer;
import com.hc.research.repository.CustomerRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Scheduled(initialDelay = 10000, fixedDelay = 5000)
    public void doTask() {
        System.out.println("doTask");
        Optional<Customer> result = this.customerRepository.findByPhone("0907958077");
        if (result.isPresent()) {
            Customer customer = result.get();
            System.out.println("name:" + customer.getName());
        }
    }
}
