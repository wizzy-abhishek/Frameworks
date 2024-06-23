package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

	public boolean verify(String username , String password)  {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
				System.err.println("Error" + e.getMessage());
			}
		
		String url = "jdbc:mysql://localhost:3306/cred" ;
		String dbUSER = "root" ;
		String dbPassword = "123456789" ; 
		String query = "SELECT * FROM credinfo where UserID = ? and password = ?" ; 
		
		try(Connection con = DriverManager.getConnection(url , dbUSER , dbPassword) ; ){
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, username);
			pstm.setString(2, password);
			ResultSet rs = pstm.executeQuery();
			if(rs.next())
				return true ; 
			con.close();
		}catch(SQLException e ) {
			e.printStackTrace();
			System.err.print("Error" + e.getMessage());
		}
		
		return false ;
	}
	
	public String sessionVerify(String username , String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
				System.err.println("Error" + e.getMessage());
			}
		
		String url = "jdbc:mysql://localhost:3306/cred" ;
		String dbUSER = "root" ;
		String dbPassword = "123456789" ; 
		String query = "SELECT * FROM credinfo where UserID = ? and password = ?" ; 
		
		try(Connection con = DriverManager.getConnection(url , dbUSER , dbPassword) ; ){
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, username);
			pstm.setString(2, password);
			ResultSet rs = pstm.executeQuery();
			if(rs.next())
				return username ; 
			con.close();
		}catch(SQLException e ) {
			e.printStackTrace();
			System.err.print("Error" + e.getMessage());
		}
		
		return null;
		
	}
}
