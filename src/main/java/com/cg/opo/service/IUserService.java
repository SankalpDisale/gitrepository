package com.cg.opo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.opo.model.User;

@Service
public interface IUserService {

	public List<User> getAllUsers();

	public User findUserById(Integer userId);

	public List<User> findUserByName(String userName);
	
	public List<User> updateUser(User user);

	public List<User> deleteUser(Integer userId);
	
	public List<User> saveUser(User user);
	
	public List<User> saveAll();
	
}
