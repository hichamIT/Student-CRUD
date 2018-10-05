package com.hicham.students;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;


public class StudentSQL {

	static String username = "root";
	static String password = "123456";
	static String dbUrl = "jdbc:mysql://localhost:3306/students";

	public static Connection getConnection() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, username , password);
			
		} catch (SQLException | ClassNotFoundException e) {
			
			System.err.println(e.getMessage());
			
		}
		
		
		return con;
	}
	
	public static int SaveStudent(Student s) {
		int st = 0;
		try {
			String sql = " INSERT INTO `studentsinfo` (`name`, `password`, `email`, `country`) VALUES (? , ? , ? , ?)";
			
			Connection con = StudentSQL.getConnection();
			PreparedStatement prepare = con.prepareStatement(sql);
			
			prepare.setString(1, s.getName());
			prepare.setString(2, s.getPassword());
			prepare.setString(3, s.getEmail());
			prepare.setString(4, s.getCountry());
			
			st = prepare.executeUpdate();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	
	}
	
	public static int UpdateStudent(Student s) {
		int st = 0;
		try {
			String sql = "update studentsinfo set name= ?, password=?, email=?, country=?  where id=? ";
			Connection con = StudentSQL.getConnection();
			PreparedStatement prepare = con.prepareStatement(sql);
			
			prepare.setString(1, s.getName());
			prepare.setString(2, s.getPassword());
			prepare.setString(3, s.getEmail());
			prepare.setString(4, s.getCountry());
			prepare.setInt(5, s.getId());
			
			st = prepare.executeUpdate();
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	
	}
	
	public static int DeleteStudent(int id) {
		int st = 0;
		try {
			String sql = "delete from studentsinfo  where id =? ";
			Connection con = StudentSQL.getConnection();
			PreparedStatement prepare = con.prepareStatement(sql);
			
			prepare.setInt(1, id);
			
			st = prepare.executeUpdate();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	
	}
	
	public static Student ReadOneStudent(int id) {
		Student std = new Student();
		try {
			String sql = "select * from studentsinfo where id = ? ";
			Connection con = StudentSQL.getConnection();
			PreparedStatement prepare = con.prepareStatement(sql);
			
			prepare.setInt(1,id);
			ResultSet result = prepare.executeQuery();
			
			if (result.next()) {
				
				std.setId(result.getInt(1));
				std.setName(result.getString(2));
				std.setPassword(result.getString(3));
				std.setEmail(result.getString(4));
				std.setCountry(result.getString(5));
				
			}
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return std;
	
	}
	
	public static List<Student> ReadAllStudent() {
		
		List<Student> list = new ArrayList<Student>();
		try {
			String sql = "select * from studentsinfo ";
			Connection con = StudentSQL.getConnection();
			PreparedStatement prepare = (PreparedStatement) con.prepareStatement(sql);
			
			ResultSet result = prepare.executeQuery();
			
			while (result.next()) {
				Student std = new Student();
				
				std.setId(result.getInt(1));
				std.setName(result.getString(2));
				std.setPassword(result.getString(3));
				std.setEmail(result.getString(4));
				std.setCountry(result.getString(5));
				
				list.add(std);
				
			} 
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	
	}
}
