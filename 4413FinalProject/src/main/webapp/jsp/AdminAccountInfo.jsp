<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
</head>
<title>Account Info</title>
<body>
    <h1>Welcome, ${admin.getFirstName()} ${admin.getLastName()}!</h1>
    <hr/>
    <p>Email: ${admin.getEmail()}</p>
    <form action="" method="post">
    	<input type="submit" name="changeButton" value="CHANGE EMAIL">
    </form>
    <form action="" method="post">
    	<input type="submit" name="changeButton" value="CHANGE PASSWORD">
    </form>
    <form action="Home.html">
    	<input type="submit" value="LOG OUT"> 
    </form>
    <hr/>
</body>