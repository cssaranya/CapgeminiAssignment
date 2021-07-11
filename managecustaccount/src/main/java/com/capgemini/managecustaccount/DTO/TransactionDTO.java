package com.capgemini.managecustaccount.DTO;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class TransactionDTO {
	@NotNull
	private double amount;
	
	@NotNull
	private String transactionType;
	
	@NotNull 
	private Date date;

	public TransactionDTO(@NotNull double amount, @NotNull String transactionType, @NotNull Date date) {
		super();
		this.amount = amount;
		this.transactionType = transactionType;
		this.date = date;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "TransactionDTO [amount=" + amount + ", transactionType=" + transactionType + ", date=" + date + "]";
	}
	
}
