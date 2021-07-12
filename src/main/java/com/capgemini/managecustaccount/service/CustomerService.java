package com.capgemini.managecustaccount.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.managecustaccount.DTO.CustomerDTO;
import com.capgemini.managecustaccount.entity.Customer;
import com.capgemini.managecustaccount.repository.CustomerRepository;
import com.capgemini.managecustaccount.service.exception.CustomerNotFoundException;

@Service
public class CustomerService {
	Logger logger = LoggerFactory.getLogger(CustomerService.class);
	
	@Autowired
	private CustomerRepository custRepository;
	
	public CustomerDTO getCustomer(Long customerId) {

		Optional<Customer> optional = custRepository.findById(customerId);
		
		ModelMapper modelMapper = new ModelMapper();
	    Customer customer = optional.orElseThrow(() -> new CustomerNotFoundException(customerId+" does not exist"));
	    
	    return modelMapper.map(customer, CustomerDTO.class);
	}

}
