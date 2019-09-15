<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Products</title>
</head>
<body>
<a href="/product/new">New Product</a>
<table>
    <thead>
        <tr>
            <th><h3>Name</h3></th>
            <th><h3>Description</h3></th>
            <th><h3>Price</h3></th>
            <th><h3>Categories</h3></th>
            <th><h3>Action</h3></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${products}" var="product">
        <tr>
        	<td><a href="/product/${product.id}"><c:out value="${product.name}"/></a></td>
        	<td><c:out value="${product.description}"/></td>
        	<td><c:out value="${product.price}"/></td>
        	<td><c:out value="${product.size}"/></td>
            <td>
            <form action="/product/${product.id}" method="post">
			    <input type="hidden" name="_method" value="delete">
			    <input type="submit" value="Delete">
			</form>
			</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>