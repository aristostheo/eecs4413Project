<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/homePageStyle.css">
</head>
<title>Home Page</title>
<body>
	<!-- CSS here for aligning?-->

	<!--   <h1 class="titleText">Electronics Store</h1> -->
	<!--     <div class="buttonsRight">
		<form action="CartServlet" method="get">
			<input type="hidden" name ="todo" value="view"/>
			<input class="adminButton" type="submit" value="View Cart"/>
		</form>
		<form action="LoginPage.html" method="get">
			<input class="adminButton" type="submit" value="Login"/>
		</form>
	</div> -->

	<jsp:include page="header.jsp" flush="true" />

	<jsp:include page="FilterSideBar.jsp" flush="true" />

	<div id="selectionBar">

		<div class="selections" id="search">
			<form action="QueryServlet" method="get">
				<p>
					<input type="text" name="searchQuery" placeholder="What are you looking for?" /> 
					<input type="hidden" name="action" value="SUBMIT" />
					<button type="submit"><i class="ri-search-line"></i></button>
				</p>
			</form>
		</div>

		<div class="selections" id="sort">
			<form action="QueryServlet" method="get">
				<p>
					<select name="sortMethod">
						<option value="SORT BY PRICE">Price</option>
						<option value="SORT BY NAME">Name</option>
					</select> <input type="submit" name="action" value="Sort" />
				</p>
			</form>
		</div>

		<div class="selections" id="all">
			<form action="QueryServlet" method="get">
				<p>
					<button type="submit" name="action" value="SHOW ALL PRODUCTS">View
						All Products</button>
				</p>
			</form>
		</div>
	</div>

	<jsp:include page="productView.jsp" flush="true" />




</body>