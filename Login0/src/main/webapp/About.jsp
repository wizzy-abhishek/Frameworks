<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "com.login.dao.LoginDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>About page</title>
</head>
<body>
	<%	
		response.setHeader("Cache-Control", "no-cache , no-store , must-revalidate");
		response.setHeader("Expires", "0"); //Proxies
	
		LoginDao dao = new LoginDao();
		String confirmation = dao.sessionVerify((String)session.getAttribute("userID"), (String)session.getAttribute("password"));
		
		
		
		if(session.getAttribute("userID") != confirmation  ){
			response.sendRedirect("login.jsp");
		}
		else if(session.getAttribute("userID") == null  ){
			response.sendRedirect("login.jsp");
		}
	%>
	I am Abhishek Anand <br>
	Thank you for coming and supporting me 
	<span>
	
	<div class="badge-base LI-profile-badge" data-locale="en_US" data-size="medium" data-theme="dark" data-type="VERTICAL" data-vanity="abhishek-anand-60b529257" data-version="v1"><a class="badge-base__link LI-simple-link" href="https://in.linkedin.com/in/abhishek-anand-60b529257?trk=profile-badge">Abhishek Anand</a></div>
              
	</span>
	
	<form action="Logout">
		<input type = "submit" value = "LOGOUT">
	</form>
</body>
</html>
