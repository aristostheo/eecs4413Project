<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/homePageStyle.css">
</head>
<title>Home Page</title>
<body>
    <!-- CSS here for aligning?-->
    <h1 class="titleText">Store Name</h1>
    <div class="buttonsRight">
		<form action="html/Cart.html" method="get">
			<input class="adminButton" type="submit" value="View Cart"/>
		</form>
		<form action="html/LoginPage.html" method="get">
			<input class="adminButton" type="submit" value="Login"/>
		</form>
	</div>
	<form method="get" action="PullProductsServlet" >
		<input type="submit" value="SHOW ALL PRODUCTS"/>
	</form>
	<div class="filters">
	<form action="" method="get">
		<table border="1">
		<tr>
			<th>Filters</th>
		</tr>
		<tr>
			<th>
				<p>Categories: <select name="categories">
				<option value="Peripherals ">Peripherals</option>
				<option value="Accessories">Accessories</option>
				<option value="Computers">Computers</option>
				</select></p>
			</th>
		</tr>
		<tr>
			<th><p>Genre: <select name="genres">
				<option value=" ">1</option>
				<option value="">2</option>
				<option value="">3</option>
				</select></p>
			</th>
		</tr>
		<tr>
			<th><p>Brand: <select name="brand">
				<option value=" ">1</option>
				<option value="">2</option>
				<option value="">3</option>
				</select></p>
			</th>
		</tr>
		<tr>
			<th><input type="submit" value="APPLY FILTER"/></th>
		</tr>
		</table>
	</form>
	<button onclick="">SORT BY PRICE</button><br/>
	<button onclick="">SORT BY NAME</button>
  	<p>Search: <input type="text"/></p>
	</div>
	
	<div class="products">
  	<table class="productListing" border='1'>
		<tr>
			<th>ADD TO CART</th>
      		<th>NAME</th>
			<th>PRICE</th>
			<th>DETAILS</th>
		</tr>
		
		<c:forEach items="${products}" var="e">
 			<tr>
 			<th><input type="checkbox" name="add"/></th>
 			<td> ${e.getId()} </td>
 			<td> ${e.getName()}</td>
 			<td> ${e.getPrice()}</td>
 			</tr>
		</c:forEach>
  			<!--- JSP here for filling table + add checkbox will then with submit add to cart or smth-->
    </table>
	</div>
   
</body>