<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "com.login.dao.LoginDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>

	<%	
		response.setHeader("Cache-Control", "no-cache , no-store , must-revalidate");
		response.setHeader("Expires", "0");
	
		LoginDao dao = new LoginDao();
		String confirmation = dao.sessionVerify((String)session.getAttribute("userID"), (String)session.getAttribute("password"));
		
		if(session.getAttribute("userID") != confirmation  ){
			response.sendRedirect("login.jsp");
		}
		else if(session.getAttribute("userID") == null  ){
			response.sendRedirect("login.jsp");
		}
	
	%>
	Welcome...${userID}
	<br>
	<a href = "About.jsp"> About </a>
	<br>
	<form action="Logout">
		<input type = "submit" value = "LOGOUT">
	</form>
</body>
</html>
