package com.capgemini.managecustaccount.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
	
	@NotNull
	private double amount;
	
	@NotNull
	private String transactionType;
	
	@CreationTimestamp
	private Date date;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="accountNumber", nullable=false)
	private Account account;

	public Transaction(@NotNull double amount, @NotNull String transactionType, Account account) {
		super();
		this.amount = amount;
		this.transactionType = transactionType;
		this.account = account;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", amount=" + amount + ", transactionType="
				+ transactionType + ", date=" + date + ", account=" + account + "]";
	}
	
}
