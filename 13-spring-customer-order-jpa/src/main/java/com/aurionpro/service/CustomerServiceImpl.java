package com.aurionpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aurionpro.entity.Customer;
import com.aurionpro.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public ResponseEntity<String> saveCustomer(List<Customer> insData) {
		customerRepo.saveAll(insData);
		return ResponseEntity.ok("Data Saved");
	}

	@Override
	public Customer showCustomerbyId(Long customerId) {
		return customerRepo.findById(customerId).get();
	}

	@Override
	public List<Customer> showAllCustomers() {
		return customerRepo.findAll();
	}

	@Override
	public ResponseEntity<String> updateCustomer(Customer updateData) {
		Customer customer= customerRepo.findById(updateData.getId()).get();
		customer.setName(updateData.getName());
		customer.setEmail(updateData.getEmail());
		customerRepo.save(customer);
		return ResponseEntity.ok("Customer Data updated");
	}

	@Override
	public ResponseEntity<String> deleteCustomer(Long customerId) {
		customerRepo.deleteById(customerId);
		return ResponseEntity.ok("Data Deleted");
	}

	

	
	

}
