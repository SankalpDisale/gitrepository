package com.cg.opo.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.opo.exception.OrderIdNotFoundException;
import com.cg.opo.exception.OrderTypeNotFoundException;
import com.cg.opo.model.PizzaOrder;
import com.cg.opo.service.IPizzaOrderService;


@RestController
@RequestMapping("/api/v1")
public class CGPizza3PizzaOrderController {
	

	@Autowired
	private IPizzaOrderService u;
	
	@GetMapping("/pizzaOrders")
	public ResponseEntity<List<PizzaOrder>> getAllPizzaOrder(){
		
		List<PizzaOrder> p= u.getAllPizzaOrder();
		if(p.isEmpty()) {
			return new ResponseEntity("Sorry! PizzaOrder not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<PizzaOrder>>(p, HttpStatus.OK);
	}
	

	@GetMapping("/pizzaOrders/{bookingOrderId}")
	public ResponseEntity<PizzaOrder> findPizzaOrderById (
			@PathVariable("bookingOrderId")Integer bookingOrderId)throws OrderIdNotFoundException{
		PizzaOrder p= u.findPizzaOrderById(bookingOrderId);
		
		return new ResponseEntity<PizzaOrder>(p, HttpStatus.OK);
	}

	

	@PostMapping("/pizzaOrders")
	public ResponseEntity<List<PizzaOrder>> insertPizzaOrder(
			@RequestBody PizzaOrder pizzaOrder){
		List<PizzaOrder> pizzaOrders= u.savePizzaOrder(pizzaOrder);
		if(pizzaOrders.isEmpty())
		{
			return new ResponseEntity("Sorry! pizzaOrder not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<PizzaOrder>>(pizzaOrders, HttpStatus.OK);
	}

	
	@PutMapping("/pizzaOrders")
	public ResponseEntity<List<PizzaOrder>> updatePizzaOrder(
			@RequestBody PizzaOrder pizzaOrder){
		List<PizzaOrder> pizzaOrders= u.updatePizzaOrder(pizzaOrder);
		if(pizzaOrders.isEmpty())
		{
			return new ResponseEntity("Sorry! pizzaOrder not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<PizzaOrder>>(pizzaOrders, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/pizzaOrders/{pizzaOrderId}")
	public ResponseEntity<List<PizzaOrder>> deleteById(
			@PathVariable("pizzaOrderId")Integer bookingOrderId) throws OrderIdNotFoundException{
		List<PizzaOrder> pizzaOrders= u.deletePizzaOrder(bookingOrderId);
		if(pizzaOrders.isEmpty() || pizzaOrders==null) {
			return new ResponseEntity("Sorry! pizzaOrderID not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<PizzaOrder>>(pizzaOrders, HttpStatus.OK);
	}
	
	@GetMapping("/pizzaOrders/byType/{orderType}")
	public ResponseEntity<List<PizzaOrder>> findOrderByType(
			@PathVariable ("orderType") String orderType) throws OrderTypeNotFoundException{
		List<PizzaOrder> pizzaOrders= u.findOrderByType(orderType);
		if(pizzaOrders==null) {
			return new ResponseEntity("Sorry! Orders not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<PizzaOrder>>(pizzaOrders, HttpStatus.OK);
	}

}
