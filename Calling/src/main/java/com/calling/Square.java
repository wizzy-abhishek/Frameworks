package com.calling;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class Square extends HttpServlet{
	
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException {
		
		/* 
		 * Method - 1 (Request Dispatcher)
		 * 
		 * int k = (int) req.getAttribute("K");
		 * 
		 * k = k * k ;
		 * 
		 * res.getWriter().print(k);
		 */
		
		/*
		 * 	Method - 2 (Send Redirect)
		 * 
		 * int k = Integer.parseInt(req.getParameter("k"));
		 * 
		 * k = k * k ;
		 * 
		 * res.getWriter().print(k);
		 * 
		 *
		 */
		
		
		/*
		 * // Method - 3 (Cookie)
		 * 
		 * int k = 0 ;
		 * 
		 * Cookie cookie[] = req.getCookies();
		 * 
		 * for(Cookie c : cookie) { if(c.getName().equals("K")) { k =
		 * Integer.parseInt(c.getValue()); } }
		 * 
		 * k *= k ;
		 * 
		 * res.getWriter().print(k);
		 */
		
		 HttpSession s = req.getSession();
			
		int k = (int)s.getAttribute("K");
		
		k *= k ;
		
		res.getWriter().print(k);
		
		
		
		
	}

}
 