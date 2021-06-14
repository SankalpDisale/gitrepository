package com.cg.opo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.opo.dao.PizzaOrderJPARepository;
import com.cg.opo.exception.OrderIdNotFoundException;
import com.cg.opo.exception.OrderTypeNotFoundException;
import com.cg.opo.model.Pizza;
import com.cg.opo.model.PizzaOrder;
import com.cg.opo.service.IPizzaOrderService;


@Service
public class PizzaOrderServiceImpl implements IPizzaOrderService{
	
	@Autowired
	private PizzaOrderJPARepository pizzaOrderRepo;

	@Transactional(readOnly = true)
	public List<PizzaOrder> getAllPizzaOrder() {
		// TODO Auto-generated method stub
		return pizzaOrderRepo.findAll();
	}


	@Transactional
	public List<PizzaOrder> updatePizzaOrder(PizzaOrder bookingOrderId) {
		// TODO Auto-generated method stub
		pizzaOrderRepo.updatePizzaO(bookingOrderId);
		return pizzaOrderRepo.findAll();
	}

	@Transactional
	public List<PizzaOrder> deletePizzaOrder(Integer bookingOrderId)throws OrderIdNotFoundException {
		// TODO Auto-generated method stub
		if(pizzaOrderRepo.findById(bookingOrderId)==null) {
			throw new OrderIdNotFoundException("Invalid OrderId Entered");
		
		}
		else {
			pizzaOrderRepo.deleteById(bookingOrderId);	
		}
		
		return  pizzaOrderRepo.findAll();
	}

	@Transactional
	public List<PizzaOrder> savePizzaOrder(PizzaOrder pizzaOrder) {
		// TODO Auto-generated method stub
		double sum = 0D;
        List<Pizza> sublist = pizzaOrder.getPizzaList();
        for (Pizza p : sublist) {
            sum += p.getSubCost();
        }
       pizzaOrder.setTotalCost(sum);
       
       double tc = pizzaOrder.getTotalCost();
		double dp = pizzaOrder.getDiscountPercent();
		//this.pizzaCostAfterCoupan = tc - tc*dp/100;
		pizzaOrder.setPizzaCostAfterCoupan(tc - tc*dp/100);
		
		pizzaOrderRepo.saveAndFlush(pizzaOrder);
		return pizzaOrderRepo.findAll();
	}
	@Override
	public List<PizzaOrder> saveAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly = true)
	public PizzaOrder findPizzaOrderById(Integer bookingOrderId) {
		// TODO Auto-generated method stub
		PizzaOrder u=pizzaOrderRepo.findById(bookingOrderId);
		return u;
	}
	@Transactional(readOnly = true)
	public List<PizzaOrder> findOrderByType(String orderType){
		List<PizzaOrder> u=pizzaOrderRepo.findByType(orderType);
		return u;

 }
}