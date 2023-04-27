package com.aurionpro.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.aurionpro.entity.Customer;


public interface CustomerService {

	ResponseEntity<String> saveCustomer(List<Customer> insData);

	Customer showCustomerbyId(Long customerId);

	List<Customer> showAllCustomers();

	ResponseEntity<String> updateCustomer(Customer updateData);

	ResponseEntity<String> deleteCustomer(Long customerId);

}
