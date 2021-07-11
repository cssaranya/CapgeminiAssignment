package com.capgemini.managecustaccount.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.managecustaccount.entity.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction,Long>{
	List<Transaction> findByAccount_AccountNumberIn(List<Long> accountNumbers);

	List<Transaction> findByAccount_AccountNumber(Long accountNumber);
}
