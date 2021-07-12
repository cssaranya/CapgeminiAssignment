package com.capgemini.managecustaccount.DTO;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class TransactionDTO {
	@NotNull
	private Long transactionId;
	
	@NotNull
	private double amount;
	
	@NotNull
	private String transactionType;
	
	private Date date;

	public TransactionDTO() {
		super();
	}
	
	public TransactionDTO(@NotNull Long transactionId,  @NotNull double amount, @NotNull String transactionType, Date date) {
		super();
		this.transactionId = transactionId;
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

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	@Override
	public String toString() {
		return "TransactionDTO [transactionId=" + transactionId + ", amount=" + amount + ", transactionType="
				+ transactionType + ", date=" + date + "]";
	}
	
}
