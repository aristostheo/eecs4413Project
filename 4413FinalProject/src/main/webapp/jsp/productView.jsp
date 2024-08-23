<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>eStore</title>
<!-- <link rel='StyleSheet' href='style.css' type='text/css'>
 -->
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
    }

    .container {
        background-color: #ffffff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        max-width: 900px;
        width: 100%;
    }

    h2 {
        text-align: center;
        color: #333;
        margin-bottom: 20px;
        font-weight: bold;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }

    table, th, td {
        border: 1px solid #ddd;
    }

    th, td {
        padding: 12px;
        text-align: center;
    }

    th {
        background-color: #007bff;
        color: white;
        text-transform: uppercase;
        font-weight: normal;
    }

    td input[type="text"] {
        width: 50px;
        padding: 5px;
        text-align: center;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    input[type="submit"], input[type="reset"] {
        background-color: #007bff;
        color: white;
        border: none;
        padding: 10px 20px;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
        margin-right: 10px;
    }

    input[type="submit"]:hover, input[type="reset"]:hover {
        background-color: #0056b3;
    }

    p a {
        color: #007bff;
        text-decoration: none;
    }

    p a:hover {
        text-decoration: underline;
    }
</style>
	<meta charset="UTF-8">
	<title>eStore</title>
	<!-- <link rel='StyleSheet' href='style.css' type='text/css'>
	 -->
</head>
<body>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <h2>Query Results</h2>
    <form method="get" action="CartServlet">
        <table border="1" cellpadding="5"> 
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
        </table><br />
        <input type="hidden" name="todo" value="add" />
        <input type="submit" value="Add to my SHOPPING CART" />
        <input type="reset" value="Reset" />
    </form>
    <p><a href="index.html">Back to Search Menu</a></p>
</body>
</html>