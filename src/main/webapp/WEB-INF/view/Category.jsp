<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Category</title>
</head>
<body>
<a href="/category/new">New Category</a>
<table>
    <thead>
        <tr>
            <th><h3>Name</h3></th>
            <th><h3>Products</h3></th>
            <th><h3>Action</h3></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${categories}" var="category">
        <tr>
        	<td><a href="/category/${category.id}"><c:out value="${category.name}"/></a></td>
        	<td><c:out value="${category.size}"/></td>
            <td>
            <form action="/category/${category.id}" method="post">
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