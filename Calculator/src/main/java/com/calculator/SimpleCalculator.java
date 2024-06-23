package com.calculator;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SimpleCalculator extends HttpServlet {
	
	public void doPost(HttpServletRequest req , HttpServletResponse res ) throws IOException{
		
		int a = Integer.parseInt(req.getParameter("num1"));
		
		int b = Integer.parseInt(req.getParameter("num2"));
		
		String op = req.getParameter("operations");
		
		switch (op) {
		
		case "+" :
			res.getWriter().println(a + b);
			break ;
		case "-" :
			res.getWriter().print(a-b);
			break;
		case "*" :
			res.getWriter().println(a*b);
			break ;
		case "/" :
			try {
				res.getWriter().print(a/b);
			}catch(Exception e) {
				res.getWriter().println("Some thing is wrong \n" + e);
			}
			break ;
		case "%" :
			try {
				res.getWriter().print(a%b);
			}catch(Exception e) {
				res.getWriter().println("Some thing is wrong \n" + e);
			}
		}
	}

}
