package com.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.login.dao.LoginDao;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	LoginDao dao = new LoginDao();
	
    public Login() {
        super();
       
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		out.println("HELLO");
		
		
		String uID = request.getParameter("uID");
		String passKey = request.getParameter("passkey");
		
		if(dao.verify(uID, passKey))
		{	
			HttpSession session = request.getSession();
			session.setAttribute("userID" , uID );
			session.setAttribute("password", passKey);
			response.sendRedirect("welcome.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
	}
}