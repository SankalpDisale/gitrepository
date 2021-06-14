package com.cg.opo.dao;

import java.util.List;

import com.cg.opo.model.User;

public interface UserJPARepository {

	List<User> findAll();

	User findById(Integer userId);
	
	List<User> findByName(String userName);

	void deleteById(Integer userId);

	void saveAndFlush(User user);

	void updateUser(User user);

}
