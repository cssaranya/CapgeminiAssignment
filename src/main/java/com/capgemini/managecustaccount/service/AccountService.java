package com.capgemini.managecustaccount.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.managecustaccount.DTO.AccountDTO;
import com.capgemini.managecustaccount.DTO.CustomerDTO;
import com.capgemini.managecustaccount.entity.Account;
import com.capgemini.managecustaccount.entity.Customer;
import com.capgemini.managecustaccount.repository.AccountRepository;
import com.capgemini.managecustaccount.service.exception.AccountNotFoundException;

@Service
public class AccountService {
	Logger logger = LoggerFactory.getLogger(CustomerService.class);
	
	@Autowired
	private AccountRepository accRepository;
	
	public AccountDTO createAccount(CustomerDTO customerDTO, double initialCredit, String accountType) {
		ModelMapper modelMapper = new ModelMapper();
		Customer customer = modelMapper.map(customerDTO, Customer.class);
		Account account = accRepository.save(new Account(null,accountType,initialCredit,"Active",customer));
		return modelMapper.map(account, AccountDTO.class);
	}

	public List<AccountDTO> getAccountDetails(Long customerId, String accountType) {
		ModelMapper modelMapper = new ModelMapper();
		List<AccountDTO> accountDTOs;
		Optional<List<Account>> optional = accRepository.findByCustomer_CustomerIdAndAccountType(customerId,accountType);
		if(optional.isPresent()) {
			List<Account> accounts = optional.get();
			accountDTOs= Arrays.asList(modelMapper.map(accounts, AccountDTO[].class));
		}
		else {
			throw new AccountNotFoundException(accountType+" does not exist for "+customerId);
		}
		
		return accountDTOs;
	}

}
