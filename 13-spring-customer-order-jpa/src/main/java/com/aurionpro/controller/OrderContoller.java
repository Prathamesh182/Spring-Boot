package com.aurionpro.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Order;
import com.aurionpro.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderContoller {

	@Autowired
	private OrderService orderService;

	@PostMapping("/addOrder")
	public ResponseEntity<String> saveOrder(@RequestBody Order insOrder){
		
		return orderService.saveOrder(insOrder);
	}
	
	@PutMapping("/customerId/{customerid}/orderId/{orderid}")
	public ResponseEntity<String> addOrderToCustomer(@PathVariable Long customerid ,@PathVariable Long orderid){
		System.out.println(customerid);
		System.out.println(orderid);
		return orderService.addOrderToCustomer(customerid,orderid);
		
	}

	@DeleteMapping("/deleteorderbyId/{orderid}")
	public ResponseEntity<String>  deleteorderByid(@PathVariable Long orderid){
		return orderService.deleteorderById(orderid);
	}

}
