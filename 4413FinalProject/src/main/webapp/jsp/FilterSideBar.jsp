<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta charset="UTF-8">
</head>

<div class="filters">
	<form action="QueryServlet" method="get">
		<table>
		<tr><td></td></tr>
		<tr>
			<th>Filter by Category</th>
		</tr>
		
		<c:forEach items="${categories}" var="c">
			<tr>
				<td><input type="checkbox" name="categories" value="${c.name}"/> ${c.name}<br></td>
			</tr>
		</c:forEach>
			<!-- <td>
				<input type="checkbox" name="categories" value="smartphones"/> Smartphones<br/>
				<input type="checkbox" name="categories" value="laptops"/> Laptops<br/>
				<input type="checkbox" name="categories" value="tablets"/> Tablets<br/>
				<input type="checkbox" name="categories" value="smartwatches"/> Smartwatches<br/>
				<input type="checkbox" name="categories" value="accessories"/> Accessories<br/>
			</td> -->
		
		<tr><td></td></tr>
		<tr>
			<th>Filter by Brand</th>
		</tr>
		
		<c:forEach items="${brands}" var="b">
			<tr>
				<td><input type="checkbox" name="brand" value="${b}"/> ${b}<br></td>
			</tr>
		</c:forEach>
		
		<!-- <tr>
			<td>
				<input type="checkbox" name="brand" value="anker"/> <label>Anker</label><br/>
				<input type="checkbox" name="brand" value="apple"/> <label>Apple</label><br/>
				<input type="checkbox" name="brand" value="dell"/> <label>Dell</label><br/>
				<input type="checkbox" name="brand" value="google"/> <label>Google</label><br/>
				<input type="checkbox" name="brand" value="logitech"/> <label>Logitech</label><br/>
				<input type="checkbox" name="brand" value="microsoft"/> <label>Microsoft</label><br/>
				<input type="checkbox" name="brand" value="samsung"/> <label>Samsung</label><br/>
				<input type="checkbox" name="brand" value="sony"/> <label>Sony</label><br/>
			</td>
		</tr> -->
		<tr>
			<td>
			<input type="hidden" name="action" value="APPLY FILTER"/>
			<input type="submit" value="Apply Filters"/>
			</td>
		</tr>
		<tr><td></td></tr>
		</table>
	</form>
</div>