package com.rdfgroup.example.finance.domain;

import com.stack.domain.BaseMongoEntity;

public class FinanceRecord extends BaseMongoEntity {
	
	String user, accountNumber;
	Integer amount;
	Bank bank;
	
	public void setBank(Bank bank) {
		this.bank = bank;
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
