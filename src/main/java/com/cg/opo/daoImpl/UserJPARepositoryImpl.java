package com.cg.opo.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.opo.dao.UserJPARepository;
import com.cg.opo.model.User;

@Repository
public class UserJPARepositoryImpl implements UserJPARepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		List<User> list=new ArrayList<User>();
		 Query q=em.createQuery("select o from User o");
		    list=q.getResultList();
		    return list; 

	}

	@Override
	public User findById(Integer userId) {
		// TODO Auto-generated method stub
		User pr=em.find(User.class, userId);
		return pr;
	}

	@Override
	public void deleteById(Integer userId) {
		// TODO Auto-generated method stub
		User pr=em.find(User.class, userId);
		em.remove(pr);
	}

	@Override
	public void saveAndFlush(User user) {
		// TODO Auto-generated method stub
		em.persist(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		em.merge(user);
	}

	@Override
	public List<User> findByName(String userName) {
		// TODO Auto-generated method stub
		List<User> list=new ArrayList<User>();
		 Query q=em.createQuery("select u from User u where u.userName=?1");
		 q.setParameter(1, userName);
		    list=q.getResultList();
		return list;
	}


}
