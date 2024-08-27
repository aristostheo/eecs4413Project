<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="UTF-8">
<!--  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"> -->
<link rel='StyleSheet' href='css/ProductView.css' type='text/css'>
</head>


		
<div id="results1">

<p id="banner">
			<img src="images/banner.png">
		</p> 
		
	<div id="contents">
		<!--  -->


			<p>
			<h3 id="resultHeader">Shop by Category</h3>
			</p>
	

		<div class="flex-container1">
			<c:forEach items="${categories}" var="e">
				<div class="flex-item">
					<table>
						<tr>
							<td><div class="prodImg">
									<img src='${cartImgs[e.id - 1]}'>
								</div></td>
						</tr>
						<tr>
							<th><a
								href="QueryServlet?categories=${e.name}&action=APPLY FILTER">${e.name}</a></th>
						</tr>

					</table>
				</div>
			</c:forEach>
		</div>

	</div>
</div>