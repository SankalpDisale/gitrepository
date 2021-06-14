package com.cg.opo.dao;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.opo.exception.InvalidMinCostException;
import com.cg.opo.exception.PizzaIdNotFoundException;
import com.cg.opo.model.Pizza;

public interface PizzaJPARepository  {
	List<Pizza> findAll();

	Pizza findById(Integer pizzaId) ;

	void deleteById(Integer pizzaId);

	void saveAndFlush(Pizza pizza);

	void updatePizza(Pizza pizza);
	
	List<Pizza> viewPizzaList(double minCost, double maxCost);
	
	List<Pizza> findByName(String pizzaName);
	
	
}
