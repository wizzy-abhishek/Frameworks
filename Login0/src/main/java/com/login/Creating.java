package com.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.login.dao.CreateDao;

@SuppressWarnings("serial")
@WebServlet("/AccountCREATE")
public class Creating extends HttpServlet {
	
	CreateDao obj = new CreateDao();
	
    public Creating() {
        super();
        
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String newUser = (String)request.getParameter("newUser");
		String newPass = (String)request.getParameter("newPassword");
		String CnewPass = (String)request.getParameter("CnewPassword");
		
		
		PrintWriter out = response.getWriter();
		
		if(newPass.equals(CnewPass)) {
			String action =  obj.created(newUser , CnewPass) ; 
			out.println(action);
			response.sendRedirect("login.jsp");
		}
		else {
			out.println("Password Mismatch");
		}
		
	}

}