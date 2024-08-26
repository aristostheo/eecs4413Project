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
    <form action="AdminChangeProdQty">
    <table border='1' cellpadding='6'>
		<tr>
		<th>PRODUCT ID</th>
		<th>BRAND</th>
		<th>NAME</th>
		<th>PRICE</th>
		<th>QUANTITY</th>
		<th>DESCRIPTION</th>
		<th>NEW TOTAL STOCK QTY</th>
	 	</tr>
        <c:forEach items="${productList}" var="e">
                <tr>
                    <td>${e.getId()}</td>
                    <td>${e.getBrand()}</td>
                    <td>${e.getName()}</td>
                    <td>${e.getPrice()}</td>
                    <td>${e.getStockQty()}</td>
                    <td>${e.getDesc()}</td>
                    <td><input type="text" name="qty"><input type="submit" name="productID" value="Change product ${e.getId()}">
                </tr>
            </c:forEach>
        </table><br />
     </form>
        <p><a href="HomeServlet">Return to home page</a></p>
</body>
</html>