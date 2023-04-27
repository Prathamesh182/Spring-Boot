package com.aurionpro.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.aurionpro.entity.Bank;

public interface BankService {

	ResponseEntity<String> saveBank(Bank bankData);

	Bank getBankById(Long bankId);

	List<Bank> getBanks();

	ResponseEntity<String> updateBankDetails(Bank bankData);

	ResponseEntity<String> addAccount(Bank bankData);

}