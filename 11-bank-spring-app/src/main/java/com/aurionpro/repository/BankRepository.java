package com.aurionpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {

}
