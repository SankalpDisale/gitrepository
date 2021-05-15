package com.cg.eis.service;

import java.util.List;

import com.cg.eis.bean.Employee;

public interface EmployeeService {
	void getScheme(Employee obj);
	
	public boolean addEmployee(Employee e);
	public boolean removeEmployee(Employee e);
	public Employee getEmployee(int eid);
	public List<Employee> getAllEmployees();
}