package com.capgemini.managecustaccount.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.managecustaccount.entity.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction,Long>{

}
