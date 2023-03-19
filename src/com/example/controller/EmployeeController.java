package com.example.controller;

import java.util.ArrayList;

import com.example.model.Employee;
import com.example.service.EmployeeService;

public class EmployeeController {
	
	EmployeeService empService;
		
	public EmployeeController() {
		super();
		this.empService = new EmployeeService();
	}

	public boolean inserted(Employee emp) {
		return this.empService.inserted(emp);
	}
	
	public boolean updated(Employee emp) {
		
		return this.empService.updated(emp);
		
	}
	
	public boolean deleted(int id) {
		
		return this.empService.deleted(id);
		
	}
	
	public Employee get(int id) {
		
		return this.empService.get(id);
		
	}
	
	public ArrayList<Employee> get() {
		
		return this.empService.get();
		
	}

}
