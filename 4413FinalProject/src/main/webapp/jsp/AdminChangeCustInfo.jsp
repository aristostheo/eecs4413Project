<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change 1 customer's info</title>
</head>
<body>
	<form action="../AdminCustomerAccountChangeServlet" method=post>
		<p>Change First Name: <input type="text" name="firstName"></p>
		<p>Change Last Name: <input type="text" name="lastName"></p>
		<p>Change Email: <input type="text" name="email"></p>
		<p>Change Password: <input type="text" name="password"></p>
		<p>Change Phone Number: <input type="text" name="phoneNumber"></p>
		<p>Change Address Line 1: <input type="text" name="address1"></p>
		<p>Change Address Line 2: <input type="text" name="address2"></p>
		<p>Change City: <input type="text" name="city"></p>
		<p>Change State: <input type="text" name="state"></p>
		<p>Change Zipcode: <input type="text" name="zipcode"></p>
		<p>Change Country: <input type="text" name="country"></p>
		<input type="reset" value="CLEAR">
		<input type="submit" value="SUBMIT">
		<input type="hidden" name="custID" value="<%= request.getParameter("custID")%>">
	</form>

</body>
</html>