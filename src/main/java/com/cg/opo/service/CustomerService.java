package com.cg.opo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.opo.exception.CustomerIdNotFoundException;
import com.cg.opo.model.Customer;



@Service
public interface CustomerService {

	public List<Customer> getAllCustomers();

	public Customer findCustomer(Integer customerId) throws CustomerIdNotFoundException;
	
	public List<Customer> findCustomerByName(String customerName);
	
	public List<Customer> findCustomerByEmail(String customerEmail);

	public List<Customer> deleteCustomer(Integer customerId) throws CustomerIdNotFoundException;

	public List<Customer> saveCustomer(Customer customer);

	public List<Customer> updateCustomer(Customer customer);
	
	public List<Customer> saveAll();
}
