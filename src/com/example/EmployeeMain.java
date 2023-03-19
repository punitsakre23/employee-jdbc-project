package com.example;

import java.util.ArrayList;

import com.example.controller.EmployeeController;
import com.example.model.Employee;

public class EmployeeMain {

	public static void main(String[] args) {
		
//		Employee emp = new Employee(1, "Happy", "IT");
		
		EmployeeController ec = new EmployeeController();
		
//		boolean isInserted = ec.inserted(emp);
//		
//		if (isInserted) {
//			System.out.println("Record is inserted successfully");
//		} else {
//			System.out.println("Some error has occured!");
//		}
		
//		boolean isUpdated = ec.updated(emp);
//		
//		if (isUpdated) {
//			System.out.println("Record is updated successfully");
//		} else {
//			System.out.println("Some error has occured!");
//		}
		
//		boolean isDeleted = ec.deleted(1);
//		
//		if (isDeleted) {
//			System.out.println("Record is deleted successfully");
//		} else {
//			System.out.println("Some error has occured!");
//		}
		
//		Employee employees = ec.get(100);
//		
//		System.out.println(employees);
		
		ArrayList<Employee> employees = ec.get();
		
		for (Employee employee : employees) {
			System.out.println(employee);
		}

	}

}
