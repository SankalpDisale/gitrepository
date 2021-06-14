package com.cg.opo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.opo.dao.CustomerJPARepository;
import com.cg.opo.exception.CustomerIdNotFoundException;
import com.cg.opo.model.Customer;
import com.cg.opo.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerJPARepository customerRepo;

	@Transactional(readOnly = true)
	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	@Transactional(readOnly = true)
	public Customer findCustomer(Integer customerId) throws CustomerIdNotFoundException {
		Customer cus=customerRepo.findById(customerId);
		if(customerRepo.findById(customerId)==null) {
			throw new CustomerIdNotFoundException("Please enter the correct customer Id ");
		}
		return cus;
	}
	
	@Transactional(readOnly = true)
	public List<Customer> findCustomerByName(String customerName) {
		// TODO Auto-generated method stub
		List<Customer> cus=customerRepo.findByName(customerName);
		return cus;
	}

	@Transactional(readOnly = true)
	public List<Customer> findCustomerByEmail(String customerEmail)  {
		// TODO Auto-generated method stub
		List<Customer> cus=customerRepo.findByEmail(customerEmail);
		return cus;
	}
	
	@Transactional
	public List<Customer> deleteCustomer(Integer customerId)throws CustomerIdNotFoundException {
		if(customerRepo.findById(customerId)==null) {
			throw new CustomerIdNotFoundException("Please enter the valid customerId to delete ");
			}
		else {
			customerRepo.deleteById(customerId);

		}
	
		return  customerRepo.findAll();
	}

	@Transactional
	public List<Customer> saveCustomer(Customer customer) {
		customerRepo.saveAndFlush(customer);

		return  customerRepo.findAll();
	}

	@Transactional
	public List<Customer> updateCustomer(Customer customer) {
		customerRepo.updateCustomer(customer);
		return  customerRepo.findAll();
	}

	public List<Customer> saveAll() {
		return null;
	}

}
