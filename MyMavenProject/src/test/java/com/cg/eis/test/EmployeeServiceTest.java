package com.cg.eis.test;

import static org.junit.Assert.*;

import org.junit.Test;
import com.cg.eis.bean.*;
import com.cg.eis.service.*;

public class EmployeeServiceTest {
EmployeeService service=new EmployeeServiceImpl();
	@Test
	public void testgetScheme() {
		Employee e=new Employee(100,"King",35000.00,"Programmer");
		service.getScheme(e);
		assertEquals("Scheme B",e.getInsuranceScheme());
		
	}
	
	@Test
	public void testaddEmployee() {
		Employee e=new Employee(100,"King",35000.00,"Programmer");
	
		assertTrue(	service.addEmployee(e));
		assertTrue(service.getAllEmployees().size()==1);
		
		assertNotNull(service.getAllEmployees().get(0));
		
		assertNotNull(service.getEmployee(100));
		assertNull(service.getEmployee(105));
		
	}

}
