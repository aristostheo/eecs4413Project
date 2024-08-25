<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="UTF-8">
<!--  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"> -->
	<link rel='StyleSheet' href='css/ProductView.css' type='text/css'> 
</head>

<div id="results">

	<div id="contents">

		<p>
		<h3>Results</h3>
		</p>
		<%-- <form method="get" action="CartServlet">
		<table>
			<tr>
				<th>&nbsp;</th>
				<th>BRAND</th>
				<th>NAME</th>
				<th>PRICE($)</th>
				<th>STOCK QTY</th>
				<th>QTY</th>
			</tr>
			<c:forEach items="${requestScope.productList}" var="e">
				<tr>
					<td><input type="checkbox" name="cb" value="${e.id}" /></td>
					<td>${e.brand}</td>
					<td>${e.name}</td>
					<td>${e.price}</td>
					<td>${e.stockQty}</td>
					<td><input type="text" name="qty${e.id}" value="1" /></td>
				</tr>
			</c:forEach>
		</table>
		<br /> <input type="hidden" name="todo" value="add" /> <input
			type="submit" value="Add to my SHOPPING CART" /> <input type="reset"
			value="Reset" />
	</form>
	<p>
		<a href="Home.html">Back to Search Menu</a>
	</p> --%>


		<div class="flex-container">
			<c:forEach items="${requestScope.productList}" var="e">
				<div class="flex-item">
					<table>
						<tr>
							<td><div class="prodImg"><img src='${e.img}'></div></td>
						</tr>
						<tr>
							<th>${e.name}</th>	
						</tr>
						<tr>
							<td>${e.brand}</td>	
						</tr>
						<tr>
							<td>&nbsp;</td>	
						</tr>
						<tr>
							<td>$${e.price}</td>	
						</tr>
						<tr>
							<td class="lastRow">	
								<input type="hidden" name="cb" value="${e.id}"/>
								<input type="hidden" name="todo" value="add" /> 
								<input type="number" name="qty${e.id}" value="1" min="1"/>
								<input type="submit" value="Add to Cart" />
							</td>	
						</tr>
						
					</table>
				</div>
			</c:forEach>
		</div>

	</div>
</div>