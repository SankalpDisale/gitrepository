package com.cg.opo.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.opo.dao.CustomerJPARepository;
import com.cg.opo.model.Customer;

@Repository
public class CustomerJPARepositoryImpl implements CustomerJPARepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Customer> findAll() {
		 List<Customer> list=new ArrayList<Customer>();
		 Query q=em.createQuery("select o from Customer o");
		    list=q.getResultList();
		    return list; 
	}

	@Override
	public Customer findById(Integer customerId) {
		Customer c=em.find(Customer.class, customerId);
		return c;
	}
	@Override
	public List<Customer> findByName(String customerName) {
		// TODO Auto-generated method stub
		List<Customer> list=new ArrayList<Customer>();
		 Query q=em.createQuery("select c from Customer c where c.customerName=?1");
		 q.setParameter(1, customerName);
		    list=q.getResultList();
		return list;
	}

	@Override
	public List<Customer> findByEmail(String customerEmail) {
		// TODO Auto-generated method stub
		List<Customer> list=new ArrayList<Customer>();
		 Query q=em.createQuery("select c from Customer c where c.customerEmail=?1");
		 q.setParameter(1, customerEmail);
		    list=q.getResultList();
		return list;
	}

	
	
	@Override
	public Customer deleteById(Integer customerId) {
		Customer c=em.find(Customer.class, customerId);
		em.remove(c);
		return c;
	}

	@Override
	public Customer saveAndFlush(Customer customer) {
		em.persist(customer);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return em.merge(customer);
	}



}

