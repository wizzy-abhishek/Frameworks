import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
		
		String name1 = "Abhishek" ;
		
		/*
		 * HttpSession session = request.getSession(); 
		 * session.setAttribute(name, name); try { response.sendRedirect("JSTL.jsp"); }
		 * catch (IOException e) {
		 * 
		 * e.printStackTrace(); }
		 */
		
		request.setAttribute("label" , name1);
		
		RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
		
		rd.forward(request, response);
		
		
	}
}
