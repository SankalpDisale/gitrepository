package com.cg.opo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.opo.dao.PizzaJPARepository;
import com.cg.opo.exception.InvalidMinCostException;
import com.cg.opo.exception.PizzaIdNotFoundException;
import com.cg.opo.model.Pizza;
import com.cg.opo.service.IPizzaService;



@Service
public class PizzaServiceImpl implements IPizzaService {

	@Autowired
	private PizzaJPARepository pizzaRepo;

	@Transactional(readOnly = true)
	public List<Pizza> getAllPizzas() throws PizzaIdNotFoundException {
		List<Pizza> u=pizzaRepo.findAll();
		if(u.isEmpty() || u==null)
		{
			throw new PizzaIdNotFoundException("Could not find any Pizza you are looking for ! :(");			
		}
		return u;
	}

	@Transactional(readOnly = true)
	public Pizza findPizza(Integer pizzaId) throws PizzaIdNotFoundException {
		Pizza piz=pizzaRepo.findById(pizzaId);
		if(pizzaRepo.findById(pizzaId) == null)
		{
			throw new PizzaIdNotFoundException("Could not find any Pizza with Id  "+pizzaId);	
		}
			return piz;
	}
	
	@Transactional(readOnly = true)
	public List<Pizza> findPizzaByName(String pizzaName)
	{
		// TODO Auto-generated method stub
		List<Pizza> u=pizzaRepo.findByName(pizzaName);
		return u;
	}
	
	@Transactional
	public List<Pizza> viewPizzaList(double minCost, double maxCost) throws InvalidMinCostException{
		
		List<Pizza> pList=pizzaRepo.viewPizzaList(minCost, maxCost);
	  if(minCost<0 || maxCost<0 || maxCost<minCost)
		{
			throw new InvalidMinCostException("Could not find any Pizza in Cost range of  "+minCost +" and "+maxCost);
		}
		return pList;
	}
	
	
	@Transactional
	public List<Pizza> deletePizza(Integer pizzaId) throws PizzaIdNotFoundException{
		if(pizzaRepo.findById(pizzaId) == null )
		{
			throw new PizzaIdNotFoundException("Could not find any Pizza with Id  "+pizzaId);	
		}
		else {
		pizzaRepo.deleteById(pizzaId);
		}
		return  pizzaRepo.findAll();
	}

	@Transactional
	public List<Pizza> savePizza(Pizza pizza) {
		
		pizzaRepo.saveAndFlush(pizza);

		return  pizzaRepo.findAll();
	}

	@Transactional
	public List<Pizza> updatePizza(Pizza pizza) {
		// TODO Auto-generated method stub
		pizzaRepo.updatePizza(pizza);


		return  pizzaRepo.findAll();
	}

	public List<Pizza> saveAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
