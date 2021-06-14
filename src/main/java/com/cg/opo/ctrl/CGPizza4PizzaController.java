package com.cg.opo.ctrl;

import java.util.InputMismatchException;
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

import com.cg.opo.exception.InvalidMinCostException;
import com.cg.opo.exception.PizzaIdNotFoundException;
import com.cg.opo.model.Pizza;
import com.cg.opo.service.IPizzaService;

@RestController
@RequestMapping("/api/v1")
public class CGPizza4PizzaController {
	
	@Autowired
	private IPizzaService pizzaService;
	
	@PutMapping("/pizzas")
	public ResponseEntity<List<Pizza>> updatePizza(
			@RequestBody Pizza pizza){
		List<Pizza> pizzas= pizzaService.updatePizza(pizza);
		if(pizzas.isEmpty())
		{
			return new ResponseEntity("Sorry! Pizzas not available!", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Pizza>>(pizzas, HttpStatus.OK);
	}
	
	@GetMapping("/pizzas/byname/{pizzaName}")
	public ResponseEntity<List<Pizza>> findPizzaByName(
			@PathVariable ("pizzaName") String pizzaName)throws PizzaIdNotFoundException{
		List<Pizza> pizzas= pizzaService.findPizzaByName(pizzaName);	
		return new ResponseEntity<List<Pizza>>(pizzas, HttpStatus.OK);
	}
	

	@GetMapping("/pizzas/bycost/{minCost}/{maxCost}")
	public ResponseEntity<List<Pizza>> viewPizzaList(@PathVariable double minCost, @PathVariable double maxCost) throws InvalidMinCostException{
		List<Pizza> pizzas= pizzaService.viewPizzaList(minCost, maxCost);
		return new ResponseEntity<List<Pizza>>(pizzas, HttpStatus.OK);
	}
	
	@PostMapping("/pizzas")
	public ResponseEntity<List<Pizza>> insertPizza(
			@RequestBody Pizza pizza){
		List<Pizza> pizzas= pizzaService.savePizza(pizza);
		if(pizzas.isEmpty())
		{
			return new ResponseEntity("Sorry! Pizzas not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Pizza>>(pizzas, HttpStatus.OK);
	}
	
	@DeleteMapping("/pizzas/{pizzaId}")
	public ResponseEntity<List<Pizza>> deletePizza(
			@PathVariable("pizzaId")Integer pizzaId) throws PizzaIdNotFoundException{
		List<Pizza> pizzas= pizzaService.deletePizza(pizzaId);
		return new ResponseEntity<List<Pizza>>(pizzas, HttpStatus.OK);
	}
	
	
	@GetMapping("/pizzas/{pizzaId}")
	public ResponseEntity<Pizza> findPizza(
			@PathVariable("pizzaId")Integer pizzaId)throws PizzaIdNotFoundException
	{Pizza pizza= pizzaService.findPizza(pizzaId);
		return new ResponseEntity<Pizza>(pizza, HttpStatus.OK);
	}

	@GetMapping("/pizzas")
	public ResponseEntity<List<Pizza>> getAllPizzas()throws PizzaIdNotFoundException{
		List<Pizza> pizzas= pizzaService.getAllPizzas();
		return new ResponseEntity<List<Pizza>>(pizzas, HttpStatus.OK);
	}
}

