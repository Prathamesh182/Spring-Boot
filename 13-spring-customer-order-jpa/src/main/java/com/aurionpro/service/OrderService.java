package com.aurionpro.service;


import org.springframework.http.ResponseEntity;

import com.aurionpro.entity.Order;

public interface OrderService {

	ResponseEntity<String> saveOrder(Order insOrder);

	ResponseEntity<String> addOrderToCustomer(Long customerid, Long orderid);

	ResponseEntity<String> deleteorderById(Long orderid);

}
