package com.aurionpro.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aurionpro.entity.Customer;
import com.aurionpro.entity.Order;
import com.aurionpro.repository.CustomerRepository;
import com.aurionpro.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public ResponseEntity<String> saveOrder(Order insOrder) {
		
//		LocalDate date = LocalDate.now();
//		String today = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//		insOrder.setDate(today);
		insOrder.setDate(LocalDateTime.now());
		orderRepo.save(insOrder);
		return ResponseEntity.ok("Order Saved");
	}

	@Override
	public ResponseEntity<String> addOrderToCustomer(Long customerid, Long orderid) {
		Customer customer = customerRepo.findById(customerid).get();
		List<Order> orders = customer.getOrders();
		Order order = orderRepo.findById(orderid).get();
		orders.add(order);
		customer.setOrders(orders);
		customerRepo.save(customer);
		return ResponseEntity.ok("Data Saved");
		
	}

	@Override
	public ResponseEntity<String> deleteorderById(Long orderid) {
		orderRepo.deleteById(orderid);
		
		return ResponseEntity.ok("Order Deleted");
	}

}
