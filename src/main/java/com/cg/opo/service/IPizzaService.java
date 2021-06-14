package com.cg.opo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.opo.exception.InvalidMinCostException;
import com.cg.opo.exception.PizzaIdNotFoundException;
import com.cg.opo.model.Pizza;


@Service
public interface IPizzaService {
	
	public List<Pizza> getAllPizzas()throws PizzaIdNotFoundException;

	public Pizza findPizza(Integer pizzaId) throws PizzaIdNotFoundException;

	public List<Pizza> findPizzaByName(String pizzaName);

	public List<Pizza> deletePizza(Integer pizzaId) throws PizzaIdNotFoundException;

	public List<Pizza> savePizza(Pizza pizza);

	public List<Pizza> updatePizza(Pizza pizza);
	
	public List<Pizza> saveAll();

	public List<Pizza> viewPizzaList(double minCost, double maxCost) throws InvalidMinCostException ;
}
