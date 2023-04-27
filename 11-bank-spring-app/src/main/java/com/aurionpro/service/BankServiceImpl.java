package com.aurionpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aurionpro.entity.Accounts;
import com.aurionpro.entity.Bank;
import com.aurionpro.entity.Customer;
import com.aurionpro.repository.AccountsRepository;
import com.aurionpro.repository.BankRepository;
import com.aurionpro.repository.CustomerRepository;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private BankRepository bankRepository;

	@Autowired
	private AccountsRepository accountRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public ResponseEntity<String> saveBank(Bank bankData) {
		bankRepository.save(bankData);
		return ResponseEntity.ok("Bank data saved");
	}

	@Override
	public Bank getBankById(Long bankId) {
		return bankRepository.findById(bankId).get();
	}

	@Override
	public List<Bank> getBanks() {
		return bankRepository.findAll();
	}

	@Override
	public ResponseEntity<String> updateBankDetails(Bank bankData) {

		// customerRepository.save(customerData);
		Bank bank = bankRepository.findById(bankData.getBankId()).get();
		bank.setFullName(bankData.getFullName());
		bank.setShortName(bankData.getShortName());
		bankRepository.save(bank);

		//bankRepository.save(bankData);
		return ResponseEntity.ok("Bank data updated");
	}

	@Override
	public ResponseEntity<String> addAccount(Bank bankData) {
		Bank bank = bankRepository.findById(bankData.getBankId()).get();
		System.out.println(bank);
		List<Accounts> accountList = bank.getAccounts();
		// System.out.println(bankData.getAccounts().get(0));
//		Accounts account = accountRepository.findById(bankData.getBankId()).get();
		Accounts account = accountRepository.findById(bankData.getAccounts().get(0).getAccountNo()).get();
//		System.out.println(bankData.getAccounts().get(0).getAccountNo());
//		System.out.println(account.getAccountNo());
		Customer customer = customerRepository.findById(account.getCustomer().getCustomerId()).get();
		for (Accounts x : bankData.getAccounts()) {
			x.setBalance(account.getBalance());
			x.setCustomer(customer);
			// x=account;
		}
		accountList.addAll(bankData.getAccounts());
		bank.setAccounts(accountList);
		bankRepository.save(bank);
		return ResponseEntity.ok("Account added");
	}

}