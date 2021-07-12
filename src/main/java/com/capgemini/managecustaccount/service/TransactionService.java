package com.capgemini.managecustaccount.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.managecustaccount.DTO.AccountDTO;
import com.capgemini.managecustaccount.DTO.TransactionDTO;
import com.capgemini.managecustaccount.entity.Account;
import com.capgemini.managecustaccount.entity.Transaction;
import com.capgemini.managecustaccount.repository.TransactionRepository;

@Service
public class TransactionService {
Logger logger = LoggerFactory.getLogger(TransactionService.class);
	
	@Autowired
	private TransactionRepository txnRepository;

	public TransactionDTO initiateCredit(AccountDTO accountDTO, double initialCredit) {
		ModelMapper modelMapper = new ModelMapper();
		Transaction transaction = txnRepository.save(new Transaction(null,initialCredit,"Credit",modelMapper.map(accountDTO,Account.class)));
		return modelMapper.map(transaction,TransactionDTO.class);
	}

	public Map<AccountDTO, List<TransactionDTO>> getTxnDetails(List<AccountDTO> accountDTOs) {
		logger.info("Inside getTxnDetails with accountDTOs "+accountDTOs);
		ModelMapper modelMapper = new ModelMapper();
		//List<Account> accounts = Arrays.asList(modelMapper.map(accountDTOs, Account[].class));
		
		Map<AccountDTO, List<TransactionDTO>> map = new HashMap<AccountDTO, List<TransactionDTO>>();
		for(AccountDTO account : accountDTOs) {
			Long accntNum = account.getAccountNumber();
			List<Transaction> transactions = txnRepository.findByAccount_AccountNumber(accntNum);
			map.put(account,Arrays.asList(modelMapper.map(transactions, TransactionDTO[].class)));
		}
		return map;
	}

}
