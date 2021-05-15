package com.cg.eis.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.eis.bean.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	List<Employee> elist=new ArrayList<>();
	
	@Override
	public boolean addEmployee(Employee e) {
		// TODO Auto-generated method stub
		return elist.add(e);
	}

	@Override
	public boolean removeEmployee(Employee e) {
		// TODO Auto-generated method stub
		return elist.remove(e);
	}

	@Override
	public Employee getEmployee(int eid) {
		// TODO Auto-generated method stub
		Employee ee=null;
		for(Employee e:elist) {
			if(e.getId()==eid) {
				ee=e;
			}
		}
		return ee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return elist;
	}

}
