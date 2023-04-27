package com.aurionpro.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.aurionpro.entity.Transaction;

public interface TransactionService {

	ResponseEntity<String> saveTransaction(Transaction transactionData);

	Transaction getTransactionById(Long transactionId);

	List<Transaction> getTransactions();

	ResponseEntity<String> updateTransactionDetails(Transaction transactionData);

}