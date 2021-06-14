package com.cg.opo.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.opo.dao.CustomerJPARepository;
import com.cg.opo.exception.CustomerIdNotFoundException;
import com.cg.opo.model.Customer;
import com.cg.opo.serviceImpl.CustomerServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class CustomerServiceTest 
{

	@Autowired
    private CustomerServiceImpl cust;

    @MockBean
    private CustomerJPARepository dao;

    
    @Test
    public void getAllCustomersTest(){

        Customer cs = new Customer();
        cs.setCustomerEmail("abc@gmail.com");
        cs.setCustomerId(1);
        cs.setCustomerName("abc");
        cs.setCustomerAddress("ede");
        cs.setCustomerMobile(565565656);

        Customer cs1 = new Customer();
        cs1.setCustomerEmail("abcd@gmail.com");
        cs1.setCustomerId(2);
        cs1.setCustomerName("abcd");
        cs1.setCustomerAddress("QQQQ");
        cs1.setCustomerMobile(64874894);
        

        List<Customer> csList = new ArrayList<>();
        csList.add(cs);
        csList.add(cs1);

        Mockito.when(dao.findAll()).thenReturn(csList);

        assertThat(cust.getAllCustomers()).isEqualTo(csList);
    }
    

    @Test
    public void deleteCustomer() throws CustomerIdNotFoundException{
        Customer customer = new Customer();
        customer.setCustomerId(5);
        customer.setCustomerAddress("Mathura");
        customer.setCustomerMobile(989689587);
        customer.setCustomerEmail("mohit@gmail.com");
        customer.setCustomerName("Mohit");
        customer.setPod(null);
        customer.setUserId(null);
        
        Mockito.when(dao.findById(5)).thenReturn(customer);
        cust.deleteCustomer(customer.getCustomerId());
        verify(dao, times(1)).deleteById(customer.getCustomerId());
    }
    
    
    @Test
    public void findCustomerByNameTest() {

    Customer c=new Customer(10,"Rishabh",787459587,"rhbh@gmail.com","brc",null,null);
    List<Customer> list = new ArrayList<>();
    Mockito.when(dao.findByName("Rishabh")).thenReturn(list);
    cust.findCustomerByName("Rishabh");
   assertEquals(list,cust.findCustomerByName("Rishabh"));
    }
    
    
    @Test
    public void findCustomerTest() throws CustomerIdNotFoundException {

    Customer c=new Customer(100,"Rishabh",987459587,"rishabh@gmail.com","Vadodara",null,null);
    Mockito.when(dao.findById(100)).thenReturn(c);
   cust.findCustomer(100);
   assertEquals(c,cust.findCustomer(100));
    }
 }


