<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<jsp:include page="main.jsp" />
<table>
<tr>
	<th>Name</th>
	<th>Vendor Id</th>
	<th>Product Type</th>
	<th>Quantity In Stock</th>
	<th>Price</th>
	<th>Pack Size</th>
</tr>
<c:forEach items="${allpro}" var="product">
	<tr>
		<td>${product.getName()}</td>
		<td>${product.getVid()}</td>
		<td>${product.getType()}</td>
		<td>${product.getQinstock()}</td>
		<td>${product.getPrice()}</td>
		<td>${product.getPcksize()}</td>

		<c:choose>
			<c:when test="${role=='ROLE_ADMIN'}">
				<td><a href="/admin/showproducts/delete/${product.getProduct_id()}">Delete</a></td></c:when>
			<c:otherwise>
				<td><a href="/empl/showproducts/delete/${product.getProduct_id()}">Delete</a></td></c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${role=='ROLE_ADMIN'}">
				<td><a href="/admin/showproducts/update?name=${product.getProduct_id()}">Update</a></td></c:when>
			<c:otherwise>
				<td><a href="/empl/showproducts/update?name=${product.getProduct_id()}">Update</a></td></c:otherwise>
		</c:choose>
	</tr>
</c:forEach>
</table>
</body>
</html>