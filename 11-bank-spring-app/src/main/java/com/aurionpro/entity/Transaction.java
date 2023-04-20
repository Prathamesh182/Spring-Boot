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

	private String transactionType;
	private String transactionDate;
	private double amount;

	@ManyToOne
	@JoinColumn(name = "fk_account_no")
	@JsonIgnore
	private Accounts accounts;

	public Transaction() {
		super();
	}

	public Transaction(Long transactionNo, String transactionType, String transactionDate, double amount,
			Accounts accounts) {
		super();
		this.transactionNo = transactionNo;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.accounts = accounts;
	}

	public Long getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(Long transactionNo) {
		this.transactionNo = transactionNo;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
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

	public Accounts getAccounts() {
		return accounts;
	}

	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Transaction [transactionNo=" + transactionNo + ", transactionType=" + transactionType
				+ ", transactionDate=" + transactionDate + ", amount=" + amount + ", accounts=" + accounts + "]";
	}

}