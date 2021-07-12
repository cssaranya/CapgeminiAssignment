package com.capgemini.managecustaccount.DTO;

import javax.validation.constraints.NotNull;

public class AccountDTO {
	@NotNull
	private Long accountNumber;
	
	@NotNull
	private String accountType;
	
	private double balance;
	
	@NotNull
	private String status;

	public AccountDTO() {
	}
	
	public AccountDTO(@NotNull Long accountNumber, @NotNull String accountType, double balance,
			@NotNull String status) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
		this.status = status;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String isActive() {
		return status;
	}

	public void setActive(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AccountDTO [accountNumber=" + accountNumber + ", accountType=" + accountType + ", balance=" + balance
				+ ", status=" + status + "]";
	}
	
}
