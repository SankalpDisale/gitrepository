package com.cg.opo.dao;

import java.util.List;

import com.cg.opo.model.PizzaOrder;

public interface PizzaOrderJPARepository {

	List<PizzaOrder> findAll();

	PizzaOrder findById(Integer pizzaOrderId);
	
	void deleteById(Integer pizzaOrderId);

	void saveAndFlush(PizzaOrder pizzaOrder);

	void updatePizzaO(PizzaOrder pizzaOrder);
	
	List<PizzaOrder> findByType(String orderType);
}
