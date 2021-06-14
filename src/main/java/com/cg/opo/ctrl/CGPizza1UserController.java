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

import com.cg.opo.model.User;
import com.cg.opo.service.IUserService;


@RestController
@RequestMapping("/api/v1")
public class CGPizza1UserController {
	

	@Autowired
	private IUserService u;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users= u.getAllUsers();
		if(users.isEmpty()) {
			return new ResponseEntity("Sorry! User not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	

	@GetMapping("/users/{userId}")
	public ResponseEntity<User> findUserById(
			@PathVariable("userId")Integer userId){
		User users= u.findUserById(userId);
		if(users==null) {
			return new ResponseEntity("Sorry! User not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<User>(users, HttpStatus.OK);
	}
	
	@GetMapping("/users/byname/{userName}")
	public ResponseEntity<List<User>> findUserByName(
			@PathVariable ("userName") String userName){
		List<User> users= u.findUserByName(userName);
		if(users==null) {
			return new ResponseEntity("Sorry! Users not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	

	@PostMapping("/users")
	public ResponseEntity<List<User>> insertUser(
			@RequestBody User user){
		List<User> users= u.saveUser(user);
		if(users.isEmpty())
		{
			return new ResponseEntity("Sorry! User not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	
	@PutMapping("/users")
	public ResponseEntity<List<User>> updateUser(
			@RequestBody User user){
		List<User> users= u.updateUser(user);
		if(users.isEmpty())
		{
			return new ResponseEntity("Sorry! User not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<List<User>> deleteUser(
			@PathVariable("userId")Integer userId){
		List<User> users= u.deleteUser(userId);
		if(users.isEmpty() || users==null) {
			return new ResponseEntity("Sorry! UserID not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	


}
