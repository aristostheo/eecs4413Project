<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
	<meta charset="utf-8">
	<link href="https://cdn.jsdelivr.net/npm/remixicon@4.3.0/fonts/remixicon.css" rel="stylesheet" />
	<link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
        href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400..900;1,400..900&family=Prata&display=swap"
        rel="stylesheet">

    <link href="css/header.css" rel="stylesheet">
</head>

<div class="topnav">
        <a class="left" href="HomeServlet" id="logo">CurrentTech</a>
        
        <c:if test="${isLoggedIn}"> 
        	<a class="right" href="LoginServlet"> Logout </a>
        </c:if>
        
        <c:if test="${not isLoggedIn}"> 
        	<a class="right" href="LoginServlet"> Login </a>
        </c:if>
        
        <%-- <c:choose>
			<c:when test="${isLoggedIn}">
				Logout
			</c:when>
			<c:otherwise>
				Login
			</c:otherwise>
		</c:choose> --%> 
		
		
		<a class="right" href="<%= request.getContextPath() %>/AccountInfoServlet"><i class="ri-user-3-line ri-lg"></i></a>
		
        <%-- <c:if test="${isLoggedIn}"> 
        	<a class="right" href="/jsp/AccountInfo.jsp"><i class="ri-user-3-line ri-lg"></i></a>
        </c:if>
        
        <c:if test="${not isLoggedIn}"> 
        	<a class="right" href="/jsp/AccountInfo.jsp"><i class="ri-user-3-line ri-lg"></i></a>
        </c:if> --%>
        
        
        
        <a class="right" href="CartServlet?todo=view"><i class="ri-shopping-cart-line ri-lg"></i></a>
</div>

<br>
