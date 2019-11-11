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
    <th>Vendorid</th>
    <th>Productid</th>
    <th>Date</th>
    <th>Quantity</th>
    <th>price</th>

</tr>
<c:forEach items="${alltrans}" var="trans">
    <tr>
        <td>${trans.getVennid()}</td>
        <td>${trans.getProddid()}</td>
        <td>${trans.getDoprodbuy()}</td>
        <td>${trans.getQuan()}</td>
        <td>${trans.getPrice()}</td>
    </tr>
</c:forEach>
</table>




</body>
</html>

