package com.rdfgroup.example.finance.model;

import com.rdfgroup.example.finance.domain.Bank;

public class FinanceRecordModel {
	
	String user, accountNumber, id;
	Integer amount;
	Bank bank;
	
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public Bank getBank() {
		return bank;
	}
	
	public String getUser() {
		return user;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setUser(String user) {
		this.user = user;
	}

	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	

}
