<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add category</title>
</head>
<body>
<table>
    <thead>
        <tr>
            <th><h3>Name</h3></th>
            <th><h3>Description</h3></th>
            <th><h3>Price</h3></th>
        </tr>
    </thead>
    <tbody>       
        <tr>
        	<td><c:out value="${product.name}"/></a></td>
        	<td><c:out value="${product.description}"/></td>
        	<td><c:out value="${product.price}"/></td>
        </tr>
    </tbody>
    <h1>All categories</h1>
    <ol>
    <c:forEach items="${product.categories}" var="cat">
		<li>${cat.name}</li>
	</c:forEach>
	</ol>
    <form:form action="/product/${product.id}" method="post" modelAttribute="categoryProduct">
    	<form:select  path="category">
			<c:forEach items="${categories}" var="cate">
				 <form:option value="${cate}">
				 	${cate.name}
				 </form:option>
	    	</c:forEach>
		</form:select>
	    <input type="submit" value="Submit"/>
	</form:form>
</table>
</body>
</html>