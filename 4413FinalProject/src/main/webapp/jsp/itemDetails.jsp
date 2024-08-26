<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item Detail</title>
<style>
            span { 
                display:flex;
            }
            img {
                align-self: center;
            }
        </style>
</head>
<body>
	<jsp:include page="header.jsp" flush="true" />
	
	<span>
            <img src="${product.img}" width="300">
            <div>
                <h2>${product.name}</h2>
                
                <p>Category: <br> ${cat}</p>
                <p>Description: <br> ${product.desc}</p>
                <p>Price: $${product.price }</p>
                <p>Quantity Remaining: ${product.stockQty}</p>
                
                <p>
                	<form method="get" action="CartServlet">	
								<input type="hidden" name="productID" value="${product.id}"/>
								<input type="hidden" name="todo" value="add" />
								<input type="number" name="qty" value="1" min="1"/>
								<input type="submit" value="Add to Cart"/>
					</form>
                </p>
           </div>
        </span>
       <br>
        <br>
       
            <a class="button" href="QueryServlet?action=SHOW+ALL+PRODUCTS"><i class="ri-corner-up-left-line"></i>Return to Catalog</a> 
       
	
	
	
</body>
</html>