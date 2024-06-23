package com.filterservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter("/addAlien")
public class IdFilter extends HttpFilter implements Filter {
       
    
    public IdFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		PrintWriter out = response.getWriter();
		System.out.println("In Filter");	
		HttpServletRequest req = (HttpServletRequest) request ;
		
		int add = Integer.parseInt(request.getParameter("add"));
		
		if(add > 0)
			chain.doFilter(request, response);
		else
			out.print("Invalid input");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
