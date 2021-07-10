package com.capgemini.managecustaccount.DTO;

import javax.validation.constraints.NotNull;

public class TransactionDTO {
	@NotNull
	private double amount;
	
	@NotNull
	private String transactionType;

	public TransactionDTO(@NotNull double amount, @NotNull String transactionType) {
		super();
		this.amount = amount;
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	@Override
	public String toString() {
		return "TransactionDTO [amount=" + amount + ", transactionType=" + transactionType + "]";
	}
	
}
