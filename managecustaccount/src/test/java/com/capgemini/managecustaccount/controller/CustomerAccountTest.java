package com.capgemini.managecustaccount.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.hamcrest.Matchers.containsString;

import com.capgemini.managecustaccount.DTO.AccountDTO;
import com.capgemini.managecustaccount.DTO.CustomerDTO;
import com.capgemini.managecustaccount.DTO.TransactionDTO;
import com.capgemini.managecustaccount.entity.Account;
import com.capgemini.managecustaccount.entity.Customer;
import com.capgemini.managecustaccount.entity.Transaction;
import com.capgemini.managecustaccount.service.AccountService;
import com.capgemini.managecustaccount.service.CustomerService;
import com.capgemini.managecustaccount.service.TransactionService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest
public class CustomerAccountTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CustomerService custService;
	
	@MockBean
	private AccountService accService;
	
	@MockBean
	private TransactionService txnService;
	
	
	@Test
	public void testCreateCurrAccount() throws Exception{
		fail("Not yet implemented");
	}

	/*
	 * @Test public void testGetAccountTransaction() throws Exception { //Given Long
	 * customerId = 1L; String accountType = "Current"; Long accntNum = 6L; Long
	 * transactionId = 5L; CustomerDTO customer = new
	 * CustomerDTO(customerId,"Saranya","CS");
	 * when(custService.getCustomer(customerId)).thenReturn(customer);
	 * 
	 * List<AccountDTO> accounts = new ArrayList<>(); AccountDTO account = new
	 * AccountDTO(accntNum,accountType,40.56,"Active"); accounts.add(account);
	 * when(accService.getAccountDetails(customerId,accountType)).thenReturn(
	 * accounts);
	 * 
	 * Map<AccountDTO, List<TransactionDTO>> transactionMap = new
	 * HashMap<AccountDTO, List<TransactionDTO>>(); List<TransactionDTO>
	 * transactions = new ArrayList<TransactionDTO>(); transactions.add(new
	 * TransactionDTO(transactionId,60.8,"Credit",null));
	 * transactionMap.put(account,transactions);
	 * 
	 * when(txnService.getTxnDetails(accounts)).thenReturn(transactionMap);
	 * 
	 * this.mockMvc.perform(get("/AccountTxn")).andExpect(status().isOk()).andExpect
	 * (content().string(containsString(new
	 * ObjectMapper().writeValueAsString(transactionMap)))); }
	 */

}
