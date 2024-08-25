<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/remixicon@4.3.0/fonts/remixicon.css" rel="stylesheet" />
<title>Your Cart</title>
</head>
<body>

	 <h1>Cart</h1>
	 <table>
	 	<tr>
            <th colspan="2">Item</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
            <th></th>
        </tr>
    	
    	<c:forEach items="${cart.items}" var="i">
    		<tr> 
        		<td><img src='${i.product.imgURL}' width ='300px'></td>
        		<td>${i.product.name}</td>
        		<td>${i.product.price}</td>
        		<td>${i.quantity}</td>
        		<td>${i.product.price * i.quantity}</td>
        		<td>
                	<form action="CartServlet">
                    	<input type="hidden" name="todo" value="remove"/>
                    	<input type="hidden" name="productID" value="${i.product.id}"/>
                  	 	<button type="submit"><i class="ri-close-large-line"></i></button>
               	 	</form>
                	<br>
                	<form action="CartServlet">
                    	<input type="hidden" value="update" />
                    	<button type="submit">Edit</button>
                	</form>
           	 	</td>
        	</tr>
    	</c:forEach>    
        
        
	 </table>
	
</body>
</html>