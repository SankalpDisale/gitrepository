package com.cg.eis.dao;
import java.util.List;

import com.cg.eis.bean.*;

public interface EmployeeDao {
	public boolean addEmployee(Employee e);
	public boolean removeEmployee(Employee e);
	public Employee getEmployee(int eid);
	public List<Employee> getAllEmployees();
}
