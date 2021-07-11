package com.capgemini.managecustaccount.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.managecustaccount.DTO.AccountDTO;
import com.capgemini.managecustaccount.DTO.TransactionDTO;
import com.capgemini.managecustaccount.entity.Account;
import com.capgemini.managecustaccount.entity.Transaction;
import com.capgemini.managecustaccount.repository.TransactionRepository;

public class TransactionService {
Logger logger = LoggerFactory.getLogger(TransactionService.class);
	
	@Autowired
	private TransactionRepository txnRepository;

	public TransactionDTO initiateCredit(AccountDTO accountDTO, double initialCredit) {
		ModelMapper modelMapper = new ModelMapper();
		Transaction transaction = txnRepository.save(new Transaction(initialCredit,"Credit",modelMapper.map(accountDTO,Account.class)));
		return modelMapper.map(transaction,TransactionDTO.class);
	}

	public Map<Long, List<TransactionDTO>> getTxnDetails(List<AccountDTO> accountDTOs) {
		ModelMapper modelMapper = new ModelMapper();
		List<Account> accounts = Arrays.asList(modelMapper.map(accountDTOs, Account[].class));
		Map<Long, List<TransactionDTO>> map = new HashMap<Long, List<TransactionDTO>>();
		for(Account account : accounts) {
			List<Transaction> transactions = txnRepository.findByAccountNumber(account.getAccountNumber());
			map.put(account.getAccountNumber(),Arrays.asList(modelMapper.map(transactions, TransactionDTO[].class)));
		}
		return map;
	}

}
