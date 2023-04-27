package com.aurionpro.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.aurionpro.entity.Accounts;

public interface AccountsService {

	ResponseEntity<String> saveAccount(Accounts accountData);

	Accounts getAccountById(Long accountId);

	List<Accounts> getAccounts();

	ResponseEntity<String> updateAccountDetails(Accounts accountData);

}