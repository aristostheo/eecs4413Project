<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" flush="true" />
	
	<h2>Checkout</h2>
	<hr>
	<h3>Shipping Address</h3>
	<c:if test="${isLoggedIn}">
		<ul style="list-style:none;">
			<li>${customer.address.addLine1}</li>
			<li>${customer.address.addLine2}</li>
			<li>${customer.address.city}</li>
			<li>${customer.address.state}</li>
			<li>${customer.address.zipCode}</li>
			<li>${customer.address.country}</li>
		</ul>

	</c:if>
	
	
	
</body>
</html>