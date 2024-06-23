<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String url = "jdbc:mysql://localhost:3306/univ" ;
String user = "root" ;
String password = "123456789";
String query = "select * from students where roll = 1 ;";
try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection(url , user , password);
	Statement stm = con.createStatement();

	ResultSet rs = stm.executeQuery(query);
	while(rs.next()){
	
out.println( rs.getInt(1) );
out.println(rs.getString(2) );
out.println(rs.getString(3)) ;

System.out.println(rs.getString(1));
System.out.println(rs.getString(2));

System.out.println(rs.getString(3));
	}
}catch(Exception e ){
	out.print(e.getMessage());
}
%>


</body>
</html>