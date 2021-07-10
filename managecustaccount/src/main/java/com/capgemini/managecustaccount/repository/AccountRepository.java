package com.capgemini.managecustaccount.repository;

import org.springframework.stereotype.Repository;

import com.capgemini.managecustaccount.entity.Account;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface AccountRepository extends CrudRepository<Account,Long>{

}
