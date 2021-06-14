package com.cg.opo.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.opo.dao.PizzaJPARepository;
import com.cg.opo.exception.InvalidMinCostException;
import com.cg.opo.exception.PizzaIdNotFoundException;
import com.cg.opo.model.Pizza;


@Repository
public class PizzaJPARepositoryImpl implements PizzaJPARepository {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Pizza> findAll() {
		// TODO Auto-generated method stub
		 List<Pizza> list=new ArrayList<Pizza>();
		 Query q=em.createQuery("select o from Pizza o");
		    list=q.getResultList();
		    return list; 
	}

	@Override
	public Pizza findById(Integer pizzaId){
		// TODO Auto-generated method stub
		Pizza pr=em.find(Pizza.class, pizzaId);
		return pr;
	}
	
	@Override
	public List<Pizza> findByName(String pizzaName) {
		// TODO Auto-generated method stub
		List<Pizza> list=new ArrayList<Pizza>();
		 Query q=em.createQuery("select p from Pizza p where p.pizzaName=?1");
		 q.setParameter(1, pizzaName);
		    list=q.getResultList();
		return list;
	}
	
	@Override
	public List<Pizza> viewPizzaList(double minCost, double maxCost){
		// TODO Auto-generated method stub
		List<Pizza> list=new ArrayList<Pizza>();
		 Query q=em.createQuery("SELECT p FROM Pizza p WHERE p.pizzaCost between  :minCost AND :maxCost");
		 q.setParameter("minCost",minCost);
		 q.setParameter("maxCost", maxCost);
		    list=q.getResultList();
		return list;
	}
	
	@Override
	public void deleteById(Integer pizzaId){
		// TODO Auto-generated method stub
		Pizza pr=em.find(Pizza.class, pizzaId);
		em.remove(pr);
	}

	@Override
	public void saveAndFlush(Pizza pizza) {
		// TODO Auto-generated method stub

		em.persist(pizza);
	}

	
	@Override
	public void updatePizza(Pizza pizza) {
		// TODO Auto-generated method stub
		em.merge(pizza);
	}

}
