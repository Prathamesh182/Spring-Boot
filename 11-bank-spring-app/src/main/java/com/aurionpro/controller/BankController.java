package com.aurionpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Bank;
import com.aurionpro.service.BankService;

@RestController
@RequestMapping("/bank")
public class BankController {

	@Autowired
	private BankService bankService;
	
	@PostMapping("/saveBank")
	public ResponseEntity<String> saveBank(@RequestBody Bank bankData){
		return bankService.saveBank(bankData);
	}
	
	@GetMapping("/getBankById/{bankId}")
	public Bank getBankById(@PathVariable Long bankId){
		return bankService.getBankById(bankId);
	}
	
	@GetMapping("/getBanks")
	public List<Bank> getBanks(){
		return bankService.getBanks();
	}
	
	@PutMapping("/updateBankDetails")
	public ResponseEntity<String> updateBankDetails(@RequestBody Bank bankData){
		return bankService.updateBankDetails(bankData);
	}
	
	@PostMapping("/addAccount")
	public ResponseEntity<String> addAccount(@RequestBody Bank bankData){
		return bankService.addAccount(bankData);
	}
}