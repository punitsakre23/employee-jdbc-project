package com.example.helper;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Helper {

	private static Connection conn;
	private static Statement stmt;
	private static PreparedStatement ps;
	
	public static Statement getStatement() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Helper.conn = DriverManager.getConnection("jdbc:mysql://localhost/emp", "root", "root");
			
			Helper.stmt = Helper.conn.createStatement();
			
			return Helper.stmt;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static PreparedStatement getPreparedStatement(String sql) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Helper.conn = DriverManager.getConnection("jdbc:mysql://localhost/emp", "root", "root");
			
			Helper.ps = Helper.conn.prepareStatement(sql);
			
			return Helper.ps;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static void closeStatement() {
		try {
			Helper.stmt.close();
			Helper.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void closePreparedStatement() {
		
		try {
			Helper.ps.close();
			Helper.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
