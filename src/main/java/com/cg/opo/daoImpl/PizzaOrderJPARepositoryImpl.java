package com.cg.opo.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.opo.dao.PizzaOrderJPARepository;
import com.cg.opo.model.PizzaOrder;



@Repository
public class PizzaOrderJPARepositoryImpl implements PizzaOrderJPARepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<PizzaOrder> findAll() {
		// TODO Auto-generated method stub
		List<PizzaOrder> list=new ArrayList<PizzaOrder>();
		 Query q=em.createQuery("select o from PizzaOrder o");
		    list=q.getResultList();
		    return list; 

	}

	@Override
	public PizzaOrder findById(Integer bookingOrderId) {
		// TODO Auto-generated method stub
		PizzaOrder pr=em.find(PizzaOrder.class, bookingOrderId);
		return pr;
	}

	@Override
	public void deleteById(Integer bookingOrderId) {
		// TODO Auto-generated method stub
		PizzaOrder pr=em.find(PizzaOrder.class, bookingOrderId);
		em.remove(pr);
	}

	@Override
	public void saveAndFlush(PizzaOrder pizzaOrder) {
		// TODO Auto-generated method stub
		em.persist(pizzaOrder);
	}

	@Override
	public void updatePizzaO(PizzaOrder pizzaOrder) {
		// TODO Auto-generated method stub
		em.merge(pizzaOrder);
	}

	@Override
    public List<PizzaOrder> findByType(String orderType) {
        // TODO Auto-generated method stub
        List<PizzaOrder> list=new ArrayList<PizzaOrder>();
         Query q=em.createQuery("select o from PizzaOrder o where o.orderType=?1");
         q.setParameter(1, orderType);
            list=q.getResultList();
        return list;
    }
	
}
