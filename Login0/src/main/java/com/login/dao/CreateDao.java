package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreateDao {
	
	public String created(String newUser, String cnewPass) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
				System.err.println("Error" + e.getMessage());
			}
		
		String url = "jdbc:mysql://localhost:3306/cred" ;
		String dbUSER = "root" ;
		String dbPassword = "123456789" ; 
		String query = "insert into credinfo (UserID , password) values(? , ?)" ;
		
		try(Connection con = DriverManager.getConnection(url , dbUSER , dbPassword) ; ){
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, newUser);
			pstm.setString(2, cnewPass);
			int executed = pstm.executeUpdate();

            if (executed > 0) {
               return "CREATED" ;
            } else {
                return "Some problem occured " ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}

}
