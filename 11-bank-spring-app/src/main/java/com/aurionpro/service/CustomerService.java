package com.aurionpro.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.aurionpro.entity.Customer;

public interface CustomerService {

	ResponseEntity<String> saveCustomer(Customer customerData);

	Customer getCustomerById(Long customerId);

	List<Customer> getCustomers();

	ResponseEntity<String> updateCustomerDetails(Customer customerData);

	ResponseEntity<String> createAccount(Customer accountData);

}