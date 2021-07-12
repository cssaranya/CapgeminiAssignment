package com.capgemini.managecustaccount.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.capgemini.managecustaccount.DTO.AccountDTO;
import com.capgemini.managecustaccount.DTO.TransactionDTO;
import com.capgemini.managecustaccount.entity.Account;
import com.capgemini.managecustaccount.entity.Customer;
import com.capgemini.managecustaccount.entity.Transaction;
import com.capgemini.managecustaccount.repository.TransactionRepository;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceTest {

	@Mock
	private TransactionRepository txnRepository;
	
	@InjectMocks
	private TransactionService txnService;
	
	@Before
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testInitiateCredit() {
		//Given
		Long transactionId = 60L;
		Transaction transaction = new Transaction(transactionId,60.8,"Credit",new Account(5L,"Current",40.56,"Active",new Customer(5L,"Wim","M")));
		
		Mockito.when(txnRepository.save(any(Transaction.class))).thenReturn(transaction);
		
		//When
		TransactionDTO txnDTO = txnService.initiateCredit(new AccountDTO(5L,"Current",40.56,"Active"), 60);
		
		//Then
		Assert.assertEquals(transactionId, txnDTO.getTransactionId());
		
	}

	  @Test 
	  public void testGetTxnDetails() { 
		  //Given
		  Long accntNum = 6L;
		  List<AccountDTO> accounts = new ArrayList<>();
		  AccountDTO accountDTO = new AccountDTO(accntNum,"Current",40.56,"Active");
		  accounts.add(accountDTO);
		  List<Transaction> transactions = new ArrayList<>();
		  Long transactionId = 5L;
		  transactions.add(new Transaction(transactionId,60.8,"Credit",new Account(accntNum,"Current",40.56,"Active",new Customer(5L,"Wim","M"))));
		  
		  Mockito.when(txnRepository.findByAccount_AccountNumber(accntNum)).thenReturn(transactions);
		  
		  //When
		  Map<AccountDTO, List<TransactionDTO>> map = txnService.getTxnDetails(accounts);
		  
		  List<TransactionDTO> txnDTOs = map.get(accountDTO);
		  Long newTransactionId = 0L;
		  for(TransactionDTO txnDTO : txnDTOs) {
			  newTransactionId = txnDTO.getTransactionId();
		  }
		  
		  //Then
		  Assert.assertEquals(transactionId, newTransactionId);
	}
	 
}
