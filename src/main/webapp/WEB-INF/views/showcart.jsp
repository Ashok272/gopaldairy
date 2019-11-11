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
<c:choose>
<c:when test="${csize==0}">
<h3>Your cart is empty</h3>
</c:when>
<c:otherwise>
<h3>Minimum amount for placing online order is 1000  </h3>
<table>
<tr>
	<th>Name</th>
	<th>Quantity</th>
	<th>Price</th>
	<th>Pack Size</th>
	<th>Maximum quantity in stock</th>
</tr>
<c:forEach items="${allcart}" var="cart">
	<tr>
		<td>${cart.getName()}</td>
		<td>${cart.getQincart()}</td>
		<td>${cart.getPrice()}</td>
		<td>${cart.getPcksize()}</td>
		<td>${cart.getMaxq()}</td>
		<td><a href="/user/showcart/delete?pid=${cart.getPid()}">Delete Item</a></td>
		<td><a href="/user/showcart/update?pid=${cart.getPid()}">Update Item</a></td>
	</tr>
</c:forEach>
</table>
<h3>Please update according to quantity in stock</h3>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${price<1000}">
<h3>The total amount is : ${price}</h3>
</c:when>
<c:otherwise>
<h3>The total amount is:${price}</h3>
<h3><a href="/user/showcart/checkout">Checkout</a></h3>
</c:otherwise>
</c:choose>

</body>
</html>