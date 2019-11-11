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
	<th>Address</th>
	<th>Website</th>
	<th>City</th>
	<th>State</th>
	<th>Pincode</th>
	<th>Email</th>
	<th>Phone No</th>
</tr>
<c:forEach items="${allven}" var="ven">
	<tr>
		<td>${ven.getName()}</td>
		<td>${ven.getAddress()}</td>
		<td>${ven.getWebsite()}</td>
		<td>${ven.getCity()}</td>
		<td>${ven.getState()}</td>
		<td>${ven.getPincode()}</td>
		<td>${ven.getEmail()}</td>
		<td>${ven.getPhone_no()}</td>
		<td><a href="/dbms/admin/showvenufacturers/delete/${ven.getName()}">Delete</a></td>
		<td><a href="/dbms/admin/showvendors/update?user=${ven.getName()}">Update</a></td>
	</tr>
</c:forEach>
</table>
</body>
</html>
