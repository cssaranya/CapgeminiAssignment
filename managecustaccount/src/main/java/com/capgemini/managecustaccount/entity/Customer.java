package com.capgemini.managecustaccount.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	
	@NotNull
	private String name;
	
	private String surname;

	@CreationTimestamp
	private Date createdDate;
	
	@UpdateTimestamp
	private Date updatedDate;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="contactId", nullable=false)
	private Contact custContact;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="customer")
	private List<Account> accounts = new ArrayList<>();

	public Customer() {
		super();
	}
	
	public Customer(@NotNull Long customerId, @NotNull String name, String surname) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.surname = surname;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", surname=" + surname + ", createDate="
				+ createdDate + ", updatedDate=" + updatedDate + ", custContact=" + custContact + ", accounts="
				+ accounts + "]";
	}

}
