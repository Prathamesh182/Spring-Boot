package com.aurionpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
