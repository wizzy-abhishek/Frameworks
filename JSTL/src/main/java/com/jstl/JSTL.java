package com.jstl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings({ "serial" })
@WebServlet("JSTL")
public class JSTL extends HttpServlet{
	

	public void doGet(HttpServletRequest request , HttpServletResponse response) {
		String name = "Abhishek" ;
		
		/*
		 * HttpSession session = request.getSession(); 
		 * session.setAttribute(name, name); try { response.sendRedirect("JSTL.jsp"); }
		 * catch (IOException e) {
		 * 
		 * e.printStackTrace(); }
		 */
		
		request.setAttribute("name" , name);
		
		RequestDispatcher rd = request.getRequestDispatcher("/JSTL.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

}
