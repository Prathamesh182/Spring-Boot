package com.aurionpro.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Accounts;
import com.aurionpro.entity.Customer;
import com.aurionpro.service.AccountsService;
import com.aurionpro.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/saveCustomer")
	public ResponseEntity<String> saveCustomer(@RequestBody Customer customerData){
		return customerService.saveCustomer(customerData);
	}
	
	@GetMapping("/getCustomerById/{customerId}")
	public Customer getCustomerById(@PathVariable Long customerId){
		return customerService.getCustomerById(customerId);
	}
	
	@GetMapping("/getCustomers")
	public List<Customer> getCustomers(){
		return customerService.getCustomers();
	}
	
	//@Bean
	@PutMapping("/updateCustomerDetails")
	public ResponseEntity<String> updateCustomerDetails(@RequestBody Customer customerData){
		return customerService.updateCustomerDetails(customerData);
	}
	
	@PostMapping("/createAccount")
	public ResponseEntity<String> createAccount(@RequestBody Customer accountData){
		return customerService.createAccount(accountData);
	}
}