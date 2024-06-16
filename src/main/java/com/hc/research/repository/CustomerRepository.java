package com.hc.research.repository;

import com.hc.research.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findBySignature(String signature);
    Optional<Customer> findByPhone(String phone);
}