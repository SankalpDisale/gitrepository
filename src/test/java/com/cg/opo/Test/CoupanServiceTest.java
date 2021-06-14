package com.cg.opo.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.opo.dao.CoupanJPARepository;
import com.cg.opo.exception.CoupanIdNotFoundException;
import com.cg.opo.model.Coupan;
import com.cg.opo.serviceImpl.CoupanServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoupanServiceTest {

	@Autowired
    private CoupanServiceImpl coupanservice;

    @MockBean
    private CoupanJPARepository dao;
    
    
    @Test
    public void getAllCoupansTest(){

        Coupan coup = new Coupan();
        coup.setCoupanId(102);
   	   	coup.setCoupanName("ZOMPAYTM");
   	   	coup.setCoupanType("Paytm");
   	   	coup.setCoupanDescription("Get 20%off upto 50rs+ 20-50rs Paytm cashback using Paytm");
   
   	
        Coupan coup1 = new Coupan();
        coup1.setCoupanId(103);
        coup1.setCoupanName("ZOMYTM");
        coup1.setCoupanType("Phonepay");
        coup1.setCoupanDescription(" 20-50rs Paytm cashback using Paytm");
        

        List<Coupan> coupList = new ArrayList<>();
        coupList.add(coup);
        coupList.add(coup1);

        Mockito.when(dao.findAll()).thenReturn(coupList);

        assertThat(coupanservice.getAllCoupans()).isEqualTo(coupList);
    }
    
    
     @Test
    public void deleteCoupan() throws CoupanIdNotFoundException{
        Coupan coup = new Coupan();
  	  coup.setCoupanId(102);
  	   coup.setCoupanName("ZOMPAYTM");
  	   coup.setCoupanType("Paytm");
  	 coup.setCoupanDescription("Get 20%off upto 50rs+ 20-50rs Paytm cashback using Paytm");
  
  	
        
        Mockito.when(dao.findById(102)).thenReturn(coup);
        coupanservice.deleteCoupan(coup.getCoupanId());
        verify(dao, times(1)).deleteById(coup.getCoupanId());
    }
    
     
   @Test
    public void findByNameTest() {
 	   
 	   Coupan c = new Coupan();
 	   
 	   c.setCoupanId(100);
 	   c.setCoupanName("ZOAYTM");
 	   c.setCoupanType("Patm");
 	  c.setCoupanDescription("Get 20%off upts+ 20-50rs Paytm cashback using Paytm");
 	   List<Coupan> u = new ArrayList<>();
 	   Mockito.when(dao.findByName("ZOATYM")).thenReturn(u);
 	  coupanservice.findCoupanByName("ZOATYM");
 	   assertEquals(u,coupanservice.findCoupanByName("ZOATYM"));
 	     }
    
	
    @Test
    public void findByIdTest() throws CoupanIdNotFoundException {

    	 Coupan c = new Coupan();
    	  c.setCoupanId(102);
    	   c.setCoupanName("ZOMPAYTM");
    	   c.setCoupanType("Paytm");
    	  c.setCoupanDescription("Get 20%off upto 50rs+ 20-50rs Paytm cashback using Paytm");
    	
    Mockito.when(dao.findById(102)).thenReturn(c);
    coupanservice.findCoupan(102);
    assertEquals(c,coupanservice.findCoupan(102));
    
    
    }
   
}
