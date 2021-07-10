package com.capgemini.managecustaccount.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.managecustaccount.DTO.AccountDTO;
import com.capgemini.managecustaccount.DTO.CustomerDTO;
import com.capgemini.managecustaccount.DTO.TransactionDTO;
import com.capgemini.managecustaccount.service.AccountService;
import com.capgemini.managecustaccount.service.CustomerService;
import com.capgemini.managecustaccount.service.TransactionService;

@RestController
@RequestMapping(value = "/")
public class CustomerAccount {
	
	Logger logger = LoggerFactory.getLogger(CustomerAccount.class);

	@Autowired
	private CustomerService custService;
	
	@Autowired
	private AccountService accService;
	
	@Autowired
	private TransactionService txnService;
	
	@PostMapping(value = "/currAccount")
	public ResponseEntity<AccountDTO> createCurrAccount(Long customerId, double initialCredit) {
		logger.info("Creating new current account for the customer "+customerId);
		
		CustomerDTO customer = custService.getCustomer(customerId);
		AccountDTO account = accService.createAccount(customer,initialCredit, "current");
		if(initialCredit>0) {
			TransactionDTO transaction = txnService.initiateCredit(account, initialCredit);
		}
		//Handle exception using ControllerAdvice
		return ResponseEntity.ok().body(account);
	}

}
