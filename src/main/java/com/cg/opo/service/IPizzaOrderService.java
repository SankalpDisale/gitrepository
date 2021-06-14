package com.cg.opo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.opo.exception.OrderIdNotFoundException;
import com.cg.opo.exception.OrderTypeNotFoundException;
import com.cg.opo.model.PizzaOrder;



@Service
public interface IPizzaOrderService {

	public List<PizzaOrder> getAllPizzaOrder();

	public PizzaOrder findPizzaOrderById(Integer pizzaOrderId) throws OrderIdNotFoundException;
	
	public List<PizzaOrder> findOrderByType(String orderType);
	
	public List<PizzaOrder> updatePizzaOrder(PizzaOrder pizzaOrder);

	public List<PizzaOrder> deletePizzaOrder(Integer pizzaOrderId)throws OrderIdNotFoundException;
	
	public List<PizzaOrder> savePizzaOrder(PizzaOrder pizzaOrder);
	
	public List<PizzaOrder> saveAll();
	
}
