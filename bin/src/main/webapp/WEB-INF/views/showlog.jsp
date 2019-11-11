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
    <th>Payment Log ID</th>
    <th>EMPLOYEE ID</th>
    <th>VENDOR ID</th>
    <th>PAYMENT TO</th>
    <th>AMOUNT</th>
    <th>Date of Payment</th>
</tr>
<c:forEach items="${allpay}" var="pay">
    <tr>
        <td>${pay.getPayid()}</td>
        <td>${pay.getEmp_id()}</td>
        <td>${pay.getVen_id()}</td>
        <td>${pay.getPtype()}</td>
        <td>${pay.getAmount()}</td>
        <td>${pay.getDop()}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>

