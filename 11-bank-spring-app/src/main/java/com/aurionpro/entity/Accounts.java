package com.aurionpro.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@Entity
@Transactional
@Table(name = "accounts_table")
public class Accounts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_no")
	private Long accountNo;

	private double balance;

	@ManyToOne
	@JoinColumn(name = "fk_bank_id")
	@JsonIgnore
	private Bank bank;

	@ManyToOne
	@JoinColumn(name = "fk_customer_id")
	@JsonIgnore
	private Customer customer;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "fk_account_no", referencedColumnName = "account_no")
//	@JsonIgnoreProperties
	private List<Transaction> transactions = new ArrayList<>();

	public Accounts() {
		super();
	}

	public Accounts(Long accountNo, double balance, Bank bank, Customer customer) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
		this.bank = bank;
		this.customer = customer;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

//	@Override
//	public String toString() {
//		return "Accounts [accountNo=" + accountNo + ", balance=" + balance + ", bank=" + bank + ", customer=" + customer
//				+ ", transactions=" + transactions + "]";
//	}

}