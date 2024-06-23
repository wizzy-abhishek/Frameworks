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
public class Filter2 extends HttpFilter implements Filter {
       
    
    public Filter2() {
        super();
        
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		PrintWriter out = response.getWriter();
		HttpServletRequest req = (HttpServletRequest) request ;
		String dname = req.getParameter("dname");
		
		
		if(dname.length() >= 3)
		chain.doFilter(request, response);
		else
			out.print("Fucker");
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
