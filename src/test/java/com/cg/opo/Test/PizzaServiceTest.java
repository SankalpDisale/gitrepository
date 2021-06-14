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

import com.cg.opo.dao.PizzaJPARepository;
import com.cg.opo.exception.PizzaIdNotFoundException;
import com.cg.opo.model.Pizza;
import com.cg.opo.serviceImpl.PizzaServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class PizzaServiceTest 
{

	@Autowired
    private PizzaServiceImpl piz;

    @MockBean
    private PizzaJPARepository dao;

    @Test
    public void getAllPizzasTest() throws PizzaIdNotFoundException{

        Pizza pizza = new Pizza();
        pizza.setPizzaId(5);
        pizza.setPizzaType("Veg");
        pizza.setPizzaName("Margherita");
        pizza.setPizzaDescription("ExtraCheese");
        pizza.setSize("Large");
        pizza.setOrderedQuantity(2);
        pizza.setPizzaCost(450);
        
        
        Pizza pizza1 = new Pizza();
        pizza1.setPizzaId(6);
        pizza1.setPizzaType("Non-Veg");
        pizza1.setPizzaName("FarmHouse");
        pizza1.setPizzaDescription("CheeseBurst");
        pizza1.setSize("Large");
        pizza1.setOrderedQuantity(2);
        pizza1.setPizzaCost(550);
        

        List<Pizza> csList = new ArrayList<>();
        csList.add(pizza);
        csList.add(pizza1);

        Mockito.when(dao.findAll()).thenReturn(csList);

        assertThat(piz.getAllPizzas()).isEqualTo(csList);
    }
    
    @Test
    public void findPizzaTest() throws PizzaIdNotFoundException {

    	Pizza pizza1 = new Pizza();
        pizza1.setPizzaId(6);
        pizza1.setPizzaType("Non-Veg");
        pizza1.setPizzaName("FarmHouse");
        pizza1.setPizzaDescription("CheeseBurst");
        pizza1.setSize("Large");
        pizza1.setOrderedQuantity(2);
        pizza1.setPizzaCost(550);
    Mockito.when(dao.findById(100)).thenReturn(pizza1);
    piz.findPizza(100);
    assertEquals(pizza1,piz.findPizza(100));
    }
    
    
    @Test
    public void deletePizza() throws PizzaIdNotFoundException{
        Pizza pizza = new Pizza();
        pizza.setPizzaId(5);
        pizza.setPizzaType("Veg");
        pizza.setPizzaName("Margherita");
        pizza.setPizzaDescription("ExtraCheese");
        pizza.setSize("Large");
        pizza.setOrderedQuantity(2);
        pizza.setPizzaCost(450);
        
        Mockito.when(dao.findById(5)).thenReturn(pizza);
        piz.deletePizza(pizza.getPizzaId());
        verify(dao, times(1)).deleteById(pizza.getPizzaId());
    }
    
 
   @Test
    public void findPizzaByNameTest(){

    Pizza pizza1=new Pizza();
    pizza1.setPizzaId(6);
    pizza1.setPizzaType("Non-Veg");
    pizza1.setPizzaName("FarmHouse");
    pizza1.setPizzaDescription("CheeseBurst");
    pizza1.setSize("Large");
    pizza1.setOrderedQuantity(2);
    pizza1.setPizzaCost(550);
    
    
    List<Pizza> list = new ArrayList<>();
    Mockito.when(dao.findByName("FarmHouse")).thenReturn(list);
    piz.findPizzaByName("FarmHouse");
   assertEquals(list,piz.findPizzaByName("FarmHouse"));
    }
    
 }