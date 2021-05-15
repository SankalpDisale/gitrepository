package com.cg.eis.pl;
import com.cg.eis.bean.*;
import com.cg.eis.service.*;
import java.util.*;
import java.io.*;
public class Demo {

	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
		EmployeeService es=new EmployeeServiceImpl();
		BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("Menu \n 1. Add Employee 2. Get Employee by id 3.Show all Employees 4. exit");
			int option=Integer.parseInt(sc.readLine());
			switch(option){
				case 1:	System.out.println("Enter id");
								int id=Integer.parseInt(sc.readLine());
								System.out.println("Enter name");
								String name=sc.readLine();
								
								System.out.println("Enter salary ");
								double sal=Double.parseDouble(sc.readLine());
								System.out.println("Enter Designation ");
								String desig=sc.readLine();
								Employee ob=new Employee(id,name,sal,desig);
								es.getScheme(ob);
								es.addEmployee(ob);
								System.out.println("Employee Created");
								break;
					
				case 2:	System.out.println("Enter Employee id");
								int eid=Integer.parseInt(sc.readLine());
								Employee eob=es.getEmployee(eid);
								System.out.println(eob);
								break;
				case 3:	List<Employee> elist=es.getAllEmployees();
									for(Employee e:elist ) {
										System.out.println(e);
									}
								break;
				case 4: 	System.out.println("Thank You");
								System.exit(0);
			}
		}	
	//	sc.close();

	}
	}
