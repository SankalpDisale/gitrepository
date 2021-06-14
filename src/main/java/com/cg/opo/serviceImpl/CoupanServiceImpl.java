package com.cg.opo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.opo.dao.CoupanJPARepository;
import com.cg.opo.exception.CoupanIdNotFoundException;
import com.cg.opo.exception.InvalidCoupanOperationException;
import com.cg.opo.model.Coupan;
import com.cg.opo.service.ICoupanService;



@Service
public class CoupanServiceImpl implements ICoupanService{
	
	@Autowired
    private CoupanJPARepository coupanRepo;


    @Transactional(readOnly = true)
    public List<Coupan> getAllCoupans() {
        return coupanRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Coupan findCoupan(Integer coupanId) throws CoupanIdNotFoundException
{
        Coupan coup=coupanRepo.findById(coupanId);
        if(coupanRepo.findById(coupanId) == null)
        {
            throw new CoupanIdNotFoundException("Could not find any Coupan with Id  "+coupanId);    
        }
            return coup;
    }
    
    @Transactional(readOnly = true)
    public List<Coupan> findCoupanByName(String coupanName){
        // TODO Auto-generated method stub
        List<Coupan> u=coupanRepo.findByName(coupanName);
        return u;
    }
 

    @Transactional
    public List<Coupan> deleteCoupan(Integer coupanId) throws CoupanIdNotFoundException{
        if(coupanRepo.findById(coupanId) == null )
        {
            throw new CoupanIdNotFoundException("Could not find any Pizza with Id  "+coupanId);    
        }
        else {
            coupanRepo.deleteById(coupanId);
        }
        return  coupanRepo.findAll();
    }
 

    @Transactional
    public List<Coupan> saveCoupan(Coupan coupan) {
        coupanRepo.saveAndFlush(coupan);

        return  coupanRepo.findAll();
    }
 

    @Transactional
    public List<Coupan> updateCoupan(Coupan coupan) throws InvalidCoupanOperationException {
        // TODO Auto-generated method stub
         if(coupan==null)
            {
                throw new InvalidCoupanOperationException("Could not find any Pizza in Cost range of  "+coupan);
            }
         else {
        coupanRepo.updateCoupan(coupan);
         }

        return  coupanRepo.findAll();
    }

 
    public List<Coupan> saveAll() {
        // TODO Auto-generated method stub
        return null;
    }
}