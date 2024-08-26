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
	
	<h4>Default Shipping Address:</h4>
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
	
	<h4>Temporary Shipping and Payment Info</h4>
	<form action="">
        <h5>Delivery Address</h5>
        <p><input type="text" placeholder="First name"/><input type="text" placeholder="Last name"/></p>
        <p><input type="text" placeholder="Address" size="40"/></p>
        <p><input type="text" placeholder="Apartment, suite, etc. (optional)" size="40"/></p>
        <p><input type="text" placeholder="City"/></p>
        <p> 
            <label for="country">Country</label>
            <select name="country">
                <option value="canada">Canada</option>
                <option value="usa">USA</option>
                <option value="mexico">Mexico</option>
            </select>
            <label for="state">State</label>
            <select>
                <option value="CA">CA</option>
                <option value="AZ">AZ</option>
                <option value="NY">NY</option>
            </select>
            <input type="text" placeholder="ZIP code" size="10"/>
        </p>
        <p><input type="tel" placeholder="Phone number (optional)"/></p>
        <br>
        <h5>Payment Information</h5>
        <p>
            <label for="card">Card Number</label>
            <input name="card" type="text" placeholder="XXXX XXXX XXXX XXXX"/>
        </p>
        <p><input type="text" placeholder="Name on Card"/></p>
        <p>Expiration Date <input type="number" min="01" max="12" value="01"/> <input type="number" min="2024" max="2030" value="2024"/></p>
        <p>Security Code <input type="text" size="3"></p>
        <br>
        <input type="submit" value="Confirm Order"/>
    </form>
	
	
</body>
</html>