<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
</head>
<title>Login Page</title>
<body>
	<jsp:include page="header.jsp" flush="true" />
	<div style="margin-left:50px;">
	
    <form action="AccountInfoServlet" method="post">
        <h1>Login</h1>
        <p>Email: <input type="text" name="email"/></p>
        <p>Password: <input type="password" name="password"/></p>
        <input type="submit" value="Submit"/><input type="reset" value="Clear"/>
    </form> 
    <a href="AccountCreation.html">Create a New Account</a>
    <a href="AdminLogin.html">Log in as Admin</a>
    </div>
</body>