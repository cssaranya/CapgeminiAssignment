package com.capgemini.managecustaccount.service;

import java.util.Optional;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.capgemini.managecustaccount.entity.Customer;
import com.capgemini.managecustaccount.repository.CustomerRepository;
import com.capgemini.managecustaccount.service.exception.CustomerNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

	@Mock
	private CustomerRepository custRepository;
	
	@InjectMocks
	private CustomerService custService;
	
	@Before
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetCustomer() {
		//Given a customerId
		Long customerId = 1L;
		
		Optional<Customer> optional = Optional.of(new Customer(customerId,"Saranya","CS"));
		
		Mockito.when(custRepository.findById(customerId)).thenReturn(optional);
		
		// When customerId exists
		Long newCustomerId = custService.getCustomer(customerId).getCustomerId();
			
		// Then
		Assert.assertEquals(customerId, newCustomerId);
	}
	
	@Test(expected = CustomerNotFoundException.class)
	public void testUrlNotFound() {
		// Given an alias
		Long customerId = 1L;

		Mockito.when(custRepository.findById(customerId))
				.thenThrow(new CustomerNotFoundException("Customer "+customerId+" does not exist."));

		// When alias does not exist
		custService.getCustomer(customerId);		
	}

}
