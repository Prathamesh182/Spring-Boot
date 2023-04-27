package com.aurionpro.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aurionpro.entity.Accounts;
import com.aurionpro.entity.Customer;
import com.aurionpro.entity.Transaction;
import com.aurionpro.repository.AccountsRepository;
import com.aurionpro.repository.CustomerRepository;
import com.aurionpro.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private AccountsRepository accountRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public ResponseEntity<String> saveTransaction(Transaction transactionData) {

		if (accountRepository.existsById(transactionData.getSender())) {
			if (accountRepository.existsById(transactionData.getReceiver())) {
				LocalDate transactionDate = LocalDate.now();
				String today = transactionDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				transactionData.setTransactionDate(today);

				// All About Sender
				Accounts senderAccount = accountRepository.findById(transactionData.getSender()).get();
				
				boolean flag = false;
				if((senderAccount.getBalance()-transactionData.getAmount()<0)){
					flag = true;
				}
				
				if(!flag) {
				
					senderAccount.setBalance(senderAccount.getBalance() - transactionData.getAmount());
					transactionData.setBalance(senderAccount.getBalance());

					//// Mapping transaction list to sender account
					List<Transaction> transactionList = senderAccount.getTransactions();
//											for(Transaction x: transactionList) {
//												x.setBalance(account.getBalance());
//												x.setCustomer(customer);
//												//x=account;
//											}
					transactionList.add(transactionData);
					senderAccount.setTransactions(transactionList);
					accountRepository.save(senderAccount);

					System.out.println();
					transactionRepository.save(transactionData);

					// All about Receiver
					Accounts receiverAccount = accountRepository.findById(transactionData.getReceiver()).get();
					receiverAccount.setBalance(receiverAccount.getBalance() + transactionData.getAmount());
					transactionData.setBalance(receiverAccount.getBalance());

					//// Mapping transaction list to receiver account
					List<Transaction> transactionList1 = receiverAccount.getTransactions();
//											for(Transaction x: transactionList) {
//												x.setBalance(account.getBalance());
//												x.setCustomer(customer);
//												//x=account;
//											}
					transactionList1.add(transactionData);
					receiverAccount.setTransactions(transactionList1);
					
					accountRepository.save(receiverAccount);
					//transactionData.setTransactionNo();
					Transaction newTransaction = new Transaction();
					newTransaction.setAccounts(transactionData.getAccounts());
					newTransaction.setAmount(transactionData.getAmount());
					newTransaction.setBalance(transactionData.getBalance());
					newTransaction.setReceiver(transactionData.getReceiver());
					newTransaction.setSender(transactionData.getSender());
					newTransaction.setTransactionDate(transactionData.getTransactionDate());
					
					System.out.println();
					//transactionRepository.save(newTransaction);

					// senderAccount.setTransactions(transactionData);

					Customer senderCustomer = customerRepository.findById(senderAccount.getCustomer().getCustomerId())
							.get();
					totalBalance(senderCustomer);
					Customer receiverCustomer = customerRepository.findById(receiverAccount.getCustomer().getCustomerId())
							.get();
					totalBalance(receiverCustomer);

					return ResponseEntity.ok("Transaction data saved");
				}
				
			}
		}

		return new ResponseEntity<>("Balance is insufficient",HttpStatus.EXPECTATION_FAILED);
	}

	private void totalBalance(Customer dbData) {

		// Customer customer =
		// customerRepository.findById(dbData.getCustomerId()).get();
		List<Accounts> accounts = dbData.getAccounts();
		double totalBalance = 0;
		for (Accounts x : accounts) {
			double bal = x.getBalance();
			totalBalance += bal;
		}
		dbData.setTotalBalance(totalBalance);
		dbData.setCustomerId(dbData.getCustomerId());
		customerRepository.save(dbData);
		System.out.println("Current Total Balance is " + totalBalance);
	}

	@Override
	public Transaction getTransactionById(Long transactionId) {
		return transactionRepository.findById(transactionId).get();
	}

	@Override
	public List<Transaction> getTransactions() {
		return transactionRepository.findAll();
	}

	@Override
	public ResponseEntity<String> updateTransactionDetails(Transaction transactionData) {
		transactionRepository.save(transactionData);
		return ResponseEntity.ok("Transaction data updated");
	}

}