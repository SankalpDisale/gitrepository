package com.cg.opo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.opo.exception.CoupanIdNotFoundException;
import com.cg.opo.exception.InvalidCoupanOperationException;
import com.cg.opo.model.Coupan;



@Service
public interface ICoupanService {
	
	public List<Coupan> getAllCoupans();

    public Coupan findCoupan(Integer coupanId)throws CoupanIdNotFoundException;

    public List<Coupan> findCoupanByName(String coupanName);

    public List<Coupan> deleteCoupan(Integer coupanId)throws CoupanIdNotFoundException;

    public List<Coupan> saveCoupan(Coupan coupan);

    public List<Coupan> updateCoupan(Coupan coupan) throws InvalidCoupanOperationException ;
    
    public List<Coupan> saveAll();
}