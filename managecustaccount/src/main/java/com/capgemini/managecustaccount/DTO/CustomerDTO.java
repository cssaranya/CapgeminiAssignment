package com.capgemini.managecustaccount.DTO;

import javax.validation.constraints.NotNull;

public class CustomerDTO {
	@NotNull
	private long customerId;
	
	@NotNull
	private String name;
	
	private String surname;

	public CustomerDTO() {
		super();
	}
	
	public CustomerDTO(@NotNull long customerId, @NotNull String name, String surname) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.surname = surname;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
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

	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", name=" + name + ", surname=" + surname + "]";
	}
	
}
