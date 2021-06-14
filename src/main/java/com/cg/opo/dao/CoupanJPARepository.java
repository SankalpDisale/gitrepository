package com.cg.opo.dao;

import java.util.List;

import com.cg.opo.model.Coupan;

public interface CoupanJPARepository {
	
	List<Coupan> findAll();

	Coupan findById(Integer coupanId);
	
	List<Coupan> findByName(String coupanName);

	void deleteById(Integer coupanId);

	void saveAndFlush(Coupan coupan);

	void updateCoupan(Coupan coupan);

}
