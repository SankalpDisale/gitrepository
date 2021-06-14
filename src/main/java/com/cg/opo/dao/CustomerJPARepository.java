package com.cg.opo.dao;

import java.util.List;

import com.cg.opo.model.Customer;

public interface CustomerJPARepository {

	List<Customer> findAll();

	Customer findById(Integer customerId);
	
	List<Customer> findByName(String customerName);
	
	List<Customer> findByEmail(String customerEmail);
	
	Customer deleteById(Integer customerId);

	Customer saveAndFlush(Customer customer);

	Customer updateCustomer(Customer customer);

}

