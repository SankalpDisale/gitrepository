package com.cg.opo.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.opo.dao.CoupanJPARepository;
import com.cg.opo.model.Coupan;



@Repository
public class CoupanJPARepositoryImpl implements CoupanJPARepository{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Coupan> findAll() {
		// TODO Auto-generated method stub
		 List<Coupan> list=new ArrayList<Coupan>();
		 Query q=em.createQuery("select o from Coupan o");
		    list=q.getResultList();
		    return list; 
	}

	@Override
	public List<Coupan> findByName(String coupanName) {
		// TODO Auto-generated method stub
		List<Coupan> list=new ArrayList<Coupan>();
		 Query q=em.createQuery("select u from Coupan u where u.coupanName=?1");
		 q.setParameter(1, coupanName);
		    list=q.getResultList();
		return list;
	}
	
	@Override
	public Coupan findById(Integer coupanId) {
		// TODO Auto-generated method stub
		Coupan pr=em.find(Coupan.class, coupanId);
		return pr;
	}

	@Override
	public void deleteById(Integer coupanId) {
		// TODO Auto-generated method stub
		Coupan pr=em.find(Coupan.class, coupanId);
		em.remove(pr);
	}

	@Override
	public void saveAndFlush(Coupan coupan) {
		// TODO Auto-generated method stub
		em.persist(coupan);
	}

	public void updateCoupan(Coupan coupan) {
		// TODO Auto-generated method stub
		em.merge(coupan);
	}

}
