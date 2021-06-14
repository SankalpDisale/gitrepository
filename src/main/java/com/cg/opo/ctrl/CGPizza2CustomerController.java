
package com.cg.opo.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.opo.exception.CustomerIdNotFoundException;
import com.cg.opo.model.Customer;
import com.cg.opo.service.CustomerService;



@RestController
@RequestMapping("/api/v1")
public class CGPizza2CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PutMapping("/customers")
	public ResponseEntity<List<Customer>> updateCustomer(@RequestBody Customer customer){
		List<Customer> customers= customerService.updateCustomer(customer);
		if(customers.isEmpty())
		{
			return new ResponseEntity("Sorry! Customers not available!", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	
	
	@PostMapping("/customers")
	public ResponseEntity<List<Customer>> insertCustomer(
			@RequestBody Customer customer){
		List<Customer> customers= customerService.saveCustomer(customer);
		if(customers.isEmpty())
		{
			return new ResponseEntity("Sorry! Customers not available!",HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	
	
	
	@DeleteMapping("/customers/{customerId}")
	public ResponseEntity<List<Customer>> deleteCustomer(
			@PathVariable("customerId")Integer customerId) throws CustomerIdNotFoundException{
		List<Customer> customers= customerService.deleteCustomer(customerId);
		
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	
	@GetMapping("/customers/{customerId}") 
	public ResponseEntity<Customer> findCustomer(
			@PathVariable("customerId")Integer customerId)throws CustomerIdNotFoundException
	{
		Customer customer= customerService.findCustomer(customerId);	
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> customers= customerService.getAllCustomers();
		if(customers.isEmpty()) {
			return new ResponseEntity("Sorry! Customers not available!",HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/customers/byname/{customerName}")
	public ResponseEntity<List<Customer>> findCustomerByName(
			@PathVariable ("customerName") String customerName){
		List<Customer> customers= customerService.findCustomerByName(customerName);
		if(customers==null) {
			return new ResponseEntity("Sorry! Customers not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/customers/byemail/{customerEmail}")
	public ResponseEntity<List<Customer>> findCustomerByEmail(
			@PathVariable ("customerEmail") String customerEmail){
		List<Customer> customers= customerService.findCustomerByEmail(customerEmail);
		if(customers==null) {
			return new ResponseEntity("Sorry! Customers not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
	}
	
}
