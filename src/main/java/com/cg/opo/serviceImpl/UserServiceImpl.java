package com.cg.opo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.opo.dao.UserJPARepository;
import com.cg.opo.model.User;
import com.cg.opo.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserJPARepository userRepo;

	@Transactional(readOnly = true)
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}


	@Transactional
	public List<User> updateUser(User user) {
		// TODO Auto-generated method stub
		userRepo.updateUser(user);
		return userRepo.findAll();
	}

	@Transactional
	public List<User> deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		userRepo.deleteById(userId);
		return userRepo.findAll();
	}

	@Transactional
	public List<User> saveUser(User user) {
		// TODO Auto-generated method stub
		userRepo.saveAndFlush(user);
		return userRepo.findAll();
	}

	@Override
	public List<User> saveAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly = true)
	public User findUserById(Integer userId) {
		// TODO Auto-generated method stub
		User u=userRepo.findById(userId);
		return u;
	}

	@Transactional(readOnly = true)
	public List<User> findUserByName(String userName) {
		// TODO Auto-generated method stub
		List<User> u=userRepo.findByName(userName);
		return u;
	}

}
