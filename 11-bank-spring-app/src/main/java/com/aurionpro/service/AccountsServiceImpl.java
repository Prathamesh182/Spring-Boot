package com.aurionpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aurionpro.entity.Accounts;
import com.aurionpro.repository.AccountsRepository;

@Service
public class AccountsServiceImpl implements AccountsService{

	@Autowired
	private AccountsRepository accountsRepository;	
	
	@Override
	public ResponseEntity<String> saveAccount(Accounts accountData) {
		accountsRepository.save(accountData);
		return ResponseEntity.ok("Account data saved");
	}

	@Override
	public Accounts getAccountById(Long accountId) {
		return accountsRepository.findById(accountId).get();
	}

	@Override
	public List<Accounts> getAccounts() {
		return accountsRepository.findAll();
	}

	@Override
	public ResponseEntity<String> updateAccountDetails(Accounts accountData) {
		accountsRepository.save(accountData);
		return ResponseEntity.ok("Account data updated");
	}

}