package com.cg.eis.service;
import java.util.List;

import com.cg.eis.bean.*;
import com.cg.eis.dao.EmployeeDao;
import com.cg.eis.dao.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDao es;
	public EmployeeServiceImpl() {
		// TODO Auto-generated constructor stub
		es=new EmployeeDaoImpl();//dao
	}
	
	
	public void getScheme(Employee obj)
	{
		double sal=obj.getSalary();
		String des=obj.getDesignation();
		if(sal<5000 && des.equals("Clerk"))
		{
			System.out.println("No Scheme");
			obj.setInsuranceScheme("No Scheme");
		}
			
		else if((sal>5000 && sal<20000 )&&des.equals("System Associate"))
		{
			System.out.println("Scheme C");
			obj.setInsuranceScheme("Scheme C");
			
		}
			
		else if(sal>=20000 &&sal<40000 && des.equals("Programmer") )
		{
			System.out.println("Scheme B");
			obj.setInsuranceScheme("Scheme B");
		}
			
		else if(sal>=40000 &&des.equals("Manager"))
		{
			System.out.println("Scheme A");
			obj.setInsuranceScheme("Scheme A");
		}
	}

	@Override
	public boolean addEmployee(Employee e) {
		// TODO Auto-generated method stub
		return es.addEmployee(e);
	}

	@Override
	public boolean removeEmployee(Employee e) {
		// TODO Auto-generated method stub
		return es.removeEmployee(e);
	}

	@Override
	public Employee getEmployee(int eid) {
		// TODO Auto-generated method stub
		return es.getEmployee(eid);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return es.getAllEmployees();
	}
}
