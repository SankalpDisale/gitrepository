package com.cg.opo.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import com.cg.opo.dao.PizzaOrderJPARepository;
import com.cg.opo.exception.OrderIdNotFoundException;
import com.cg.opo.exception.OrderTypeNotFoundException;
import com.cg.opo.model.PizzaOrder;
import com.cg.opo.serviceImpl.PizzaOrderServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
class PizzaOrderServiceTest 
{

	@Autowired
    private PizzaOrderServiceImpl piz;

    @MockBean
    private PizzaOrderJPARepository dao;

   
 
    @Test
    public void getAllPizzasOrderTest() throws OrderIdNotFoundException{

    	 PizzaOrder pizza = new PizzaOrder();
         pizza.setBookingOrderId(10);
         pizza.setOrderType("Online");
         pizza.setTransactionMode("Cash");
         pizza.setTotalCost(0);
         pizza.setPizzaCostAfterCoupan(0);
         pizza.setOrderDateL(null);
        
         PizzaOrder pizza1 = new PizzaOrder();
         pizza1.setBookingOrderId(11);
         pizza1.setOrderType("Online");
         pizza1.setTransactionMode("NetBanking");
         pizza1.setTotalCost(0);
         pizza1.setPizzaCostAfterCoupan(0);
         pizza1.setOrderDateL(null);
        

        List<PizzaOrder> csList = new ArrayList<>();
        csList.add(pizza);
        csList.add(pizza1);

        Mockito.when(dao.findAll()).thenReturn(csList);

        assertThat(piz.getAllPizzaOrder()).isEqualTo(csList);
    }
    
    
    @Test
    public void deletePizzaOrder() throws OrderIdNotFoundException{
        PizzaOrder pizza = new PizzaOrder();
        pizza.setBookingOrderId(10);
        pizza.setOrderType("Online");
        pizza.setTransactionMode("Cash");
        pizza.setTotalCost(0);
        pizza.setPizzaCostAfterCoupan(0);
        pizza.setOrderDateL(null);
        
        Mockito.when(dao.findById(10)).thenReturn(pizza);
        piz.deletePizzaOrder(pizza.getBookingOrderId());
        verify(dao, times(1)).deleteById(pizza.getBookingOrderId());
    }
 
    
   @Test
    public void findPizzaOrderByTypeTest() throws OrderTypeNotFoundException {

    	PizzaOrder pizza1 = new PizzaOrder();
        pizza1.setBookingOrderId(15);
        pizza1.setOrderType("Online");
        pizza1.setTransactionMode("NetBanking");
        pizza1.setTotalCost(0);
        pizza1.setPizzaCostAfterCoupan(0);
        pizza1.setOrderDateL(null);
        pizza1.setOrderDateL(null);
        pizza1.setCoupan(null);
        pizza1.setCustomer(null);
        pizza1.setPizzaList(null);
    
        List<PizzaOrder> poList = new ArrayList<>();

        Mockito.when(dao.findByType("Online")).thenReturn(poList);
        piz.findOrderByType("Online");
        assertEquals(poList,piz.findOrderByType("Online"));
        }
   
   
    @Test
    public void findPizzaOrderTest(){

    	PizzaOrder pizza1 = new PizzaOrder();
        pizza1.setBookingOrderId(11);
        pizza1.setOrderType("Online");
        pizza1.setTransactionMode("NetBanking");
        pizza1.setTotalCost(0);
        pizza1.setPizzaCostAfterCoupan(0);
        pizza1.setOrderDateL(null);
        pizza1.setCoupan(null);
        pizza1.setCustomer(null);
        pizza1.setPizzaList(null);
        Mockito.when(dao.findById(100)).thenReturn(pizza1);
        piz.findPizzaOrderById(100);
        assertEquals(pizza1,piz.findPizzaOrderById(100));
    }
 }