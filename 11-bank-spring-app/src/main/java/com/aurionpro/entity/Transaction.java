package com.aurionpro.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@Entity
@Transactional
@Table(name = "transaction_table")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_no")
	private Long transactionNo;

	private Long sender;
	private Long receiver;
	//private String transactionType;
	//private String transactionDetail;
	private String transactionDate;
	private double amount;
	private double balance;

	@ManyToOne
	@JoinColumn(name = "fk_account_no")
	@JsonIgnore
	private Accounts accounts;

	public Transaction() {
		super();
	}

	public Transaction(Long transactionNo, Long sender, Long receiver, String transactionDate, double amount,
			double balance, Accounts accounts) {
		super();
		this.transactionNo = transactionNo;
		this.sender = sender;
		this.receiver = receiver;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.balance = balance;
		this.accounts = accounts;
	}

	public Long getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(Long transactionNo) {
		this.transactionNo = transactionNo;
	}

	public Long getSender() {
		return sender;
	}

	public void setSender(Long sender) {
		this.sender = sender;
	}

	public Long getReceiver() {
		return receiver;
	}

	public void setReceiver(Long receiver) {
		this.receiver = receiver;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Accounts getAccounts() {
		return accounts;
	}

	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}
}