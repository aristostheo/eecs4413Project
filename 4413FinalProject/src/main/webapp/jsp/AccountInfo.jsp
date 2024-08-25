<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
</head>
<title>Account Info</title>
<body>
    <h1>Welcome, ${customer.getFullName()}!</h1>
    <hr/>
    <p>Email: ${customer.getEmail()}</p>
    <form action="ChangeEmail.html" method="post">
    	<input type="submit" name="changeButton" value="CHANGE EMAIL">
    </form>
    <form action="ChangePassword.html" method="post">
    	<input type="submit" name="changeButton" value="CHANGE PASSWORD">
    </form>
    <form action="Home.html">
    	<input type="submit" value="LOG OUT"> 
    </form>
    <hr/>
    <h1>Purchase History:</h1>
    <!-- Table needs to be populated with JSP-->
    <table border='1' cellpadding='6'>
		<tr>
		<th>NAME</th>
		<th>PRICE</th>
		<th>DETAILS</th>
		<th>ORDER DATE</th>
		<th>DELIVERY DATE</th>
	 	</tr>
        <c:forEach items="${purchaseHistory}" var="e">
                <tr>
                    <td>${e.getProductName()}</td>
                    <td>${e.getPrice()}</td>
                    <td>${e.getProductDesc()}</td>
                    <td>${e.getOrderDate()}</td>
                    <td>${e.getDeliveryDate()}</td>
                </tr>
            </c:forEach>
        </table><br />

</body>