package com.aurionpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Accounts;
import com.aurionpro.entity.Bank;
import com.aurionpro.service.AccountsService;
import com.aurionpro.service.BankService;

@RestController
@RequestMapping("/account")
public class AccountsController {

	@Autowired
	private AccountsService accountsService;
	
	@PostMapping("/saveAccount")
	public ResponseEntity<String> saveAccount(@RequestBody Accounts accountData){
		return accountsService.saveAccount(accountData);
	}
	
	@GetMapping("/getAccountById/{accountId}")
	public Accounts getAccountById(@PathVariable Long accountId){
		return accountsService.getAccountById(accountId);
	}
	
	@GetMapping("/getAccounts")
	public List<Accounts> getAccounts(){
		return accountsService.getAccounts();
	}
	
	@PutMapping("/updateAccountDetails")
	public ResponseEntity<String> updateAccountDetails(@RequestBody Accounts accountData){
		return accountsService.updateAccountDetails(accountData);
	}
}