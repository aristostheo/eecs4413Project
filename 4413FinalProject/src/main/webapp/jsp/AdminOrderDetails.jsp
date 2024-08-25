<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All order information</title>
</head>
<body>
	<h1>Order history Details</h1>
	
	<table border='1' cellpadding='6'>
		<tr>
		<th>PURCHASE ORDER ID</th>
		<th>BRAND</th>
		<th>NAME</th>
		<th>CATEGORY</th>
		<th>CUSTOMER</th>
		<th>CUSTOMER EMAIL</th>
		<th>CUSTOMER ADDRESS</th>
		<th>ORDER DATE</th>
		<th>TOTAL</th>
		<th>STATUS</th>
		<th>DELIVERY DATE</th>
		<th>QUANTITY</th>
	 	</tr>
        <c:forEach items="${orderDetails}" var="e">
                <tr>
                    <td>${e.getOrderID()}</td>
                    <td>${e.getBrand()}</td>
                    <td>${e.getProductName()}</td>
                    <td>${e.getCatName()}</td>
                    <td>${e.getFullName()}</td>
                    <td>${e.getEmail()}</td>
                    <td>${e.getAddress()}</td>
                    <td>${e.getOrderDate()}</td>
                    <td>${e.getTotalAmt()}</td>
                    <td>${e.getStatus()}</td>
                    <td>${e.getDeliveryDate()}</td>
                    <td>${e.getQty()}</td>
                </tr>
            </c:forEach>
        </table><br />
</body>
</html>