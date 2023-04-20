package com.aurionpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aurionpro.entity.Bank;
import com.aurionpro.repository.BankRepository;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private BankRepository bankRepository;

	@Override
	public ResponseEntity<String> saveBank(Bank bankData) {

		bankRepository.save(bankData);
		return ResponseEntity.ok("Bank Data Saved");
	}

	@Override
	public Bank getBankById(Long bankId) {
		return	bankRepository.findById(bankId).get();
		 
	}

	@Override
	public List<Bank> getBanks() {
		return bankRepository.findAll();
	}

	@Override
	public ResponseEntity<String> updateBankDetails(Bank bankData) {
		bankRepository.save(bankData);
		
		return ResponseEntity.ok("Bank Data Updated");

	}

	

	

	

}
