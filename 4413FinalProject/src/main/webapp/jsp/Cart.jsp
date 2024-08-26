<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/remixicon@4.3.0/fonts/remixicon.css" rel="stylesheet" />
<link href="css/cart.css" rel="stylesheet"/>
<script src="js/cart.js"></script>
<title>Your Cart</title>
</head>
<body>
	
	<jsp:include page="header.jsp" flush="true" />
	
	 <h2>Your Cart</h2>
	 
	<div class="flex-container">
	<div id="cart">
		
	 <table>
	 	<tr>
            <th colspan="2">&ensp;&ensp;&ensp; Item</th>
            <th>Price</th>
            <th id="qtyHeader">Quantity</th>
            <th>Total</th>
            <th></th>
        </tr>
    	
    	<c:forEach items="${cart.items}" var="i">
    		<tr class="items"> 
        		<td class="prodImg"><img src='${i.product.img}'></td>
        		<td class="prodName">${i.product.name} <br> <small>${i.product.brand}</small></td>
        		<td>$${i.product.price}</td>
        		<td id="qtyCol">
        			<form id ="updateForm" action="CartServlet">
                    	<input type="hidden" name="todo" value="update"/>
                    	<input type="hidden" name="productID" value="${i.product.id}"/>
                    	<input type="number" name="qty" value="${i.quantity}" onChange="update()" min="1" />
                	</form>
        		</td>
        		<td>$<fmt:formatNumber value="${i.total}" type="number" maxFractionDigits="2" /></td>
           	 	<td  class="crossCol">
                	<form action="CartServlet">
                    	<input type="hidden" name="todo" value="remove"/>
                    	<input type="hidden" name="productID" value="${i.product.id}"/>
                  	 	<button type="submit"><i class="ri-close-large-line"></i></button>
               	 	</form>
               	 </td>
        	</tr>
    	</c:forEach>    
        <%-- <tr>
        	<th colspan="4" id="total-label">Subtotal: </th>
        	<th>$<fmt:formatNumber value="${cart.total}" type="number" maxFractionDigits="2" /></th>
        	<th></th>
        </tr> --%>
        
	 </table>
	 
         <br><br>         
       <a class="button" href="QueryServlet?action=SHOW+ALL+PRODUCTS"><i class="ri-corner-up-left-line"></i> Continue Shopping</a>   
		<br><br><br> 
	</div>
	
	<div id="cartTotals">
		<table id="totalCart">
			<c:set var="shipping" value="10.00" />
			<c:set var="tax" value="50.00" />
			<tr>
				<th>Summary</th>
			</tr>
			<tr>
				<td>Subtotal</td>
				<td class="numCol">$<fmt:formatNumber value="${cart.total}" type="number" maxFractionDigits="2" /></td>
			</tr>
			<tr>
				<td>Shipping</td>
				<td class="numCol">$${shipping }</td>
			</tr>
			<tr>
				<td>Tax</td>
				<td class="numCol">$${tax}</td>
			</tr>
			<tr>
				<th>Order Total</th>
				<th class="numCol">$<fmt:formatNumber value="${cart.total + shipping + tax}" type="number" maxFractionDigits="2" /></th>
			</tr>
			<tr>
				<td colspan="2" id="checkout"><a class="button"  href="CheckoutServlet">Checkout</a>  </td>  
			</tr>
		</table> 
		   
       
	</div>
	
	</div>
	
	
	
</body>
</html>