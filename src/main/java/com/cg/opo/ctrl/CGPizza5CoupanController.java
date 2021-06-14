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

import com.cg.opo.exception.CoupanIdNotFoundException;
import com.cg.opo.exception.InvalidCoupanOperationException;
import com.cg.opo.model.Coupan;
import com.cg.opo.service.ICoupanService;


@RestController
@RequestMapping("/api/v1")
public class CGPizza5CoupanController {
	@Autowired
    private ICoupanService coupanService;
    
    
    @PutMapping("/coupans")
    public ResponseEntity<List<Coupan>> updateCoupan(
            @RequestBody Coupan coupan) throws InvalidCoupanOperationException{
        List<Coupan> coupans= coupanService.updateCoupan(coupan);
        if(coupans.isEmpty())
        {
            return new ResponseEntity("Sorry! Coupans not available!", 
                    HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<List<Coupan>>(coupans, HttpStatus.OK);
    }
    
    
    
    @PostMapping("/coupans")
    public ResponseEntity<List<Coupan>> insertCoupan(
            @RequestBody Coupan coupan){
        List<Coupan> coupans= coupanService.saveCoupan(coupan);
        if(coupans.isEmpty())
        {
            return new ResponseEntity("Sorry! Coupans not available!", 
                    HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<List<Coupan>>(coupans, HttpStatus.OK);
    }
    
    @DeleteMapping("/coupans/{coupanId}")
    public ResponseEntity<List<Coupan>> deleteCoupan(
            @PathVariable("coupanId")Integer coupanId)throws CoupanIdNotFoundException{
        List<Coupan> coupans= coupanService.deleteCoupan(coupanId);
        if(coupans.isEmpty() || coupans==null) {
            return new ResponseEntity("Sorry! Coupans Id not available!", 
                    HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<List<Coupan>>(coupans, HttpStatus.OK);
    }
    
    
    @GetMapping("/coupans/{coupanId}")
    public ResponseEntity<Coupan> findCoupan(
            @PathVariable("coupanId")Integer coupanId)throws CoupanIdNotFoundException{
        Coupan coupan= coupanService.findCoupan(coupanId);
        if(coupan==null) {
            return new ResponseEntity("Sorry! Coupans not found!", 
                    HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<Coupan>(coupan, HttpStatus.OK);
    }

 

    @GetMapping("/coupans")
    public ResponseEntity<List<Coupan>> getAllCoupans(){
        List<Coupan> coupans= coupanService.getAllCoupans();
        if(coupans.isEmpty()) {
            return new ResponseEntity("Sorry! Coupans not available!", 
                    HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<List<Coupan>>(coupans, HttpStatus.OK);
    }
    
    @GetMapping("/coupans/byname/{coupanName}")
    public ResponseEntity<List<Coupan>> findCoupanByName(
            @PathVariable ("coupanName") String coupanName) throws CoupanIdNotFoundException{
        List<Coupan> coupans= coupanService.findCoupanByName(coupanName);
        if(coupans==null) {
            return new ResponseEntity("Sorry! Coupans not found!", 
                    HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<List<Coupan>>(coupans, HttpStatus.OK);
    }
}