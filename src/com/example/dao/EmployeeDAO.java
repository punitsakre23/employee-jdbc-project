package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.helper.Helper;
import com.example.model.Employee;

public class EmployeeDAO {
	
	public boolean inserted(Employee emp) {
		boolean isInserted = false;
		
		String sql = "INSERT INTO EMPLOYEES (ID, age, first, last, dept) VALUES (?, ?, ?, ?, ?);";
		
		try {
			
			PreparedStatement ps = Helper.getPreparedStatement(sql);
			
			ps.setInt(1, emp.getEmployeeId());
			ps.setInt(2, 21);
			ps.setString(3, emp.getEmployeeName());
			ps.setString(4, "Singh");
			ps.setString(5, emp.getEmployeeDepartment());
			
			int tempNoOfRecords = ps.executeUpdate();
			
			if (tempNoOfRecords >= 1) {
				isInserted = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Helper.closePreparedStatement();
		
		return isInserted;
	}
	
	public boolean updated(Employee emp) {
		boolean isUpdated = false;
		
		String sql = "UPDATE EMPLOYEES SET DEPT = ? WHERE ID = ?";
		
		try {
			
			PreparedStatement ps = Helper.getPreparedStatement(sql);
			
			ps.setString(1, emp.getEmployeeDepartment());
			ps.setInt(2, emp.getEmployeeId());
			
			int noOfRecordsUpdated = ps.executeUpdate();
			
			if (noOfRecordsUpdated >= 1) {
				isUpdated = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isUpdated;
	}
	
	public boolean deleted(int id) {
		boolean isDeleted = false;
		
		String sql = "DELETE FROM EMPLOYEES WHERE ID = ?";
		
		try {
			
			PreparedStatement ps = Helper.getPreparedStatement(sql);
			
			ps.setInt(1, id);
			
			int noOfRecordsDeleted = ps.executeUpdate();
			
			if (noOfRecordsDeleted >= 1) {
				isDeleted = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isDeleted;
	}
	
	public Employee get(int id) {
		ArrayList<Employee> emp = new ArrayList<>();
		
		String sql = "SELECT ID, CONCAT(FIRST, ' ', LAST) AS NAME, DEPT FROM EMPLOYEES WHERE ID = ?";
		
		try {

			PreparedStatement ps = Helper.getPreparedStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String empDept = rs.getString(3);
				
				Employee tempEmp = new Employee(empId, empName, empDept);
				emp.add(tempEmp);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emp.get(0);
	}
	
	public ArrayList<Employee> get() {
		ArrayList<Employee> emp = new ArrayList<>();
		
		String sql = "SELECT ID, CONCAT(FIRST, ' ', LAST) AS NAME, DEPT, SALARY FROM EMPLOYEES";
		
		try {

			Statement stmt = Helper.getStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String empDept = rs.getString(3);
				int empSalary = rs.getInt("salary");
				
				Employee tempEmp = new Employee(empId, empName, empDept, empSalary);
				emp.add(tempEmp);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emp;
	}

}
