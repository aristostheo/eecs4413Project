<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Customer Information:</h1>
    <!-- Table needs to be populated with JSP-->
    <form action="jsp/AdminChangeCustInfo">
    <table border='1' cellpadding='6'>
		<tr>
		<th>CUSTOMER ID</th>
		<th>NAME</th>
		<th>EMAIL</th>
		<th>PASSWORD</th>
		<th>PHONE NUMBER</th>
		<th>ADDRESS</th>
		<th>CHANGE</th>
	 	</tr>
        <c:forEach items="${customerDetails}" var="e">
                <tr>
                    <td>${e.getCustomerId()}</td>
                    <td>${e.getFullName()}</td>
                    <td>${e.getEmail()}</td>
                    <td>${e.getPassword()}</td>
                    <td>${e.getPhoneNumber()}</td>
                    <td>${e.getFullAddress()}</td>
                    <td><input type="submit" name="custID" value="Change Cust ${e.getCustomerId()}"></td>
                </tr>
            </c:forEach>
        </table><br />
     </form>
        <p><a href="jsp/Home.jsp">Return to home page</a></p>
</body>
</html>