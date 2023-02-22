package com.ibtech.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "iban")
	private String iban;
	
	@Column(name = "currency_type")
	private String currencyType;
	
	@Column(name = "balance")
	private int balance;
	
	@Column(name = "last_transaction")
	private LocalDate lastTransaction;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public Account() {
		super();
	}

	public Account(String iban, String currencyType, int balance, LocalDate lastTransaction, Customer customer) {

		this.iban = iban;
		this.currencyType = currencyType;
		this.balance = balance;
		this.lastTransaction = lastTransaction;
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public LocalDate getLastTransaction() {
		return lastTransaction;
	}

	public void setLastTransaction(LocalDate lastTransaction) {
		this.lastTransaction = lastTransaction;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "account [id=" + id + ", iban=" + iban + ", currencyType=" + currencyType + ", balance=" + balance
				+ ", lastTransaction=" + lastTransaction + ", customer=" + customer + "]";
	}
	
	

}
