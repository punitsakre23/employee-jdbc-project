package com.example.helper;

import java.util.Comparator;

import com.example.model.Employee;

public class EmployeeSalaryComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		
		return o2.getEmployeeSalary() - o1.getEmployeeSalary();
	
	}

}
