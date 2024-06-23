package com.calling;

import java.io.IOException;

// import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class Taking_Number extends HttpServlet {
	
	public void doGet(HttpServletRequest req , HttpServletResponse res ) throws ServletException, IOException {
		
		int k = Integer.parseInt(req.getParameter("userNumber"));
		
		/*
		 * req.setAttribute("K", k); 
		 * 
		 * res.getWriter().print("I am here");
		 * 
		 * RequestDispatcher rd = req.getRequestDispatcher("Sq");
		 * 
		 * rd.forward(req, res);
		 */
		
		
		/* 	Method - 2 (SendRedirect)
		 * 
		 * res.sendRedirect("Sq?k=" + k);
		 * 
		 * 
		 */
		
		/*
		 * // Method - 3 (Cookie)
		 * 
		 * Cookie c = new Cookie("K" , k + "");
		 * 
		 * res.addCookie(c);
		 * 
		 * res.sendRedirect("Sq");
		 */
		
		HttpSession s = req.getSession();
		
		s.setAttribute("K", k);
		
		res.sendRedirect("Sq");
		
		
	}

}