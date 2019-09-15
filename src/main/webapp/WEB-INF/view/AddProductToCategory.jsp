<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add product</title>
</head>
<body>
<h1>${categoryProduct.category.name}</h1>

<h2>All products</h2>
	<ol>
    <c:forEach items="${categoryProduct.category.products}" var="singleProd">
		<li>${singleProd.name}</li>
	</c:forEach>
	</ol>
	
	 <form:form action="/category/${categoryProduct.category.id}" method="post" modelAttribute="categoryProduct">
    	<form:select  path="product">
			<c:forEach items="${products}" var="prod">
				 <form:option value="${prod}">
				 	${prod.name}
				 </form:option>
	    	</c:forEach>
		</form:select>
	    <input type="submit" value="Submit"/>
	</form:form>
</body>
</html>