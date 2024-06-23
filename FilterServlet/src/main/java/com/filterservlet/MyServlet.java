package com.filterservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addAlien")
public class MyServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		
		int add = Integer.parseInt(request.getParameter("add"));
		
		String dname = request.getParameter("dname");
		
		out.print("Hello ALIEN " + add + dname);
		System.out.println("In servlet");
	}

}
