package com.aurionpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Customer;
import com.aurionpro.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/saveCustomer")
	public ResponseEntity<String> saveCustomer(@RequestBody List<Customer> insData){
		return customerService.saveCustomer(insData);
	}
	
	@GetMapping("/getCustomerById/{customerId}")
	public Customer showCustomer(@PathVariable Long customerId){
		return customerService.showCustomerbyId(customerId);
	}
	
	@GetMapping("/getAllCustomers")
	public List<Customer> showAllCustomer(){
		return customerService.showAllCustomers();
	}
	
	@PutMapping("updateCustomer")
	public ResponseEntity<String> UpdateCustomer(@RequestBody Customer updateData){
		return customerService.updateCustomer(updateData);
	}
	
	@DeleteMapping("/deleteCustomerByid/{customerId}")
	public ResponseEntity<String>  deleteCustomerByid(@PathVariable Long customerId){
		return customerService.deleteCustomer(customerId);
	}



}
