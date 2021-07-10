package com.capgemini.managecustaccount.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.managecustaccount.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long>{

}
