package com.example.service;

import java.util.ArrayList;
import java.util.Collections;

import com.example.dao.EmployeeDAO;
import com.example.helper.EmployeeNameComparator;
import com.example.helper.EmployeeSalaryComparator;
//import com.example.helper.EmployeeSalaryComparator;
import com.example.model.Employee;

public class EmployeeService {
	
	EmployeeDAO empDAO;
		
	public EmployeeService() {
		super();
		this.empDAO = new EmployeeDAO();
	}

	public boolean inserted(Employee emp) {
		return this.empDAO.inserted(emp);
	}
	
	public boolean updated(Employee emp) {
		
		return this.empDAO.updated(emp);
		
	}
	
	public boolean deleted(int id) {
		
		return this.empDAO.deleted(id);
		
	}
	
	public Employee get(int id) {
		
		return this.empDAO.get(id);
		
	}
	
	public ArrayList<Employee> get() {
		
		ArrayList<Employee> empList = this.empDAO.get();
		
		Collections.sort(empList, new EmployeeNameComparator());
		
		return empList;
		
	}

}
