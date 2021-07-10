package com.capgemini.managecustaccount.service;

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

}
