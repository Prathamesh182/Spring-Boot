package com.aurionpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
