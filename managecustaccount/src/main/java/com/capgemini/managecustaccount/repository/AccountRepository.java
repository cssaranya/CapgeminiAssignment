package com.capgemini.managecustaccount.repository;

import org.springframework.stereotype.Repository;

import com.capgemini.managecustaccount.entity.Account;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface AccountRepository extends CrudRepository<Account,Long>{
	Optional<List<Account>> findByCustomer_CustomerIdAndAccountType(Long customerId, String accountType);
}
