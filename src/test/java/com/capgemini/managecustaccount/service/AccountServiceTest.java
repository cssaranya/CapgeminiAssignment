package com.capgemini.managecustaccount.service;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.capgemini.managecustaccount.entity.Customer;
import com.capgemini.managecustaccount.DTO.AccountDTO;
import com.capgemini.managecustaccount.DTO.CustomerDTO;
import com.capgemini.managecustaccount.entity.Account;
import com.capgemini.managecustaccount.repository.AccountRepository;

import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

	@Mock
	private AccountRepository accRepository;
	
	@InjectMocks
	private AccountService accService;
	
	@Before
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testCreateAccount() {
		//Given
		Long accountNumber = 5L;
		Customer customer = new Customer(5L,"Wim","M");
		Account account = new Account(accountNumber,"Current",40.56,"Active",customer);
		Mockito.when(accRepository.save(any(Account.class))).thenReturn(account);
		
		//When
		Long newAccountNumber = accService.createAccount(new CustomerDTO(5L,"Wim","M"), 40.56, "Current").getAccountNumber();
		Assert.assertEquals(accountNumber, newAccountNumber);
	}
	
	@Test
	public void testGetAccountDetails() {
		//Given
		Long customerId = 5L;
		String accountType = "Savings";
		Long accntNum = 6L;
		List<Account> accounts = new ArrayList<>();
		accounts.add(new Account(accntNum,accountType,40.56,"Active",new Customer(customerId,"Wim","M")));
		Optional<List<Account>> optional = Optional.of(accounts);
		Mockito.when(accRepository.findByCustomer_CustomerIdAndAccountType(customerId, accountType)).thenReturn(optional);
		
		//When
		List<AccountDTO> newAccounts= accService.getAccountDetails(customerId, accountType);
		Long newAccntNum = 0L;
		for(AccountDTO accountDTO : newAccounts) {
			newAccntNum = accountDTO.getAccountNumber();
		}
		
		//Then
		Assert.assertEquals(accntNum,newAccntNum);
	}
	
}
