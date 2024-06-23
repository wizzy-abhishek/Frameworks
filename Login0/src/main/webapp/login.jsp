<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> LOGIN PAGE </title>
</head>
<body>
<form action = "login" method = "post">

	<label>Enter Username</label>
	<input type = "text" name ="uID">
	<br>
	<label>Enter Password</label>
	<input type = "password" name ="passkey">
	<br>
	<input type = "submit" value = "LOGIN"><br>

</form>
<form action="create" method = "post">
<input type = "submit" value = "CREATE A NEW ACCOUNT" >
</form>
</body>
</html>
