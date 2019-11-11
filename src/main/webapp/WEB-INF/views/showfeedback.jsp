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
    <th>Feedback ID</th>
    <th>Username</th>
    <th>Feedback</th>
    <th>Suggestion</th>
    <th>Date of feedback</th>

</tr>
<c:forEach items="${allfeedback}" var="feed">
    <tr>
        <td>${feed.getFeedback_id()}</td>
        <td>${feed.getUsername()}</td>
        <td>${feed.getFeed_back()}</td>
        <td>${feed.getSuggestion()}</td>
        <td>${feed.getDof()}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>

