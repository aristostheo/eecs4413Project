<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" flush="true" />
	
	 <h2>Error in Checkout</h2>
	 
	 <p>${errorMessage}</p>
	 
	        <a class="button" href="CartServlet?todo=view"><i class="ri-corner-up-left-line"></i>Return to Cart</a>   
	 
</body>
</html>