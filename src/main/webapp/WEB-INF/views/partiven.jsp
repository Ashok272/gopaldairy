<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<jsp:include page="main.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Feed back is Here</title>
</head>
<body>
<center>

<p><b><h1>Your Feedback Is Imporatant !!!</h1></b></p>




	<form:form method="post" modelAttribute="feedback" action="feedback" id="usrform">
	
	<h2>Feedback</h2>
	

	<textarea rows="4" cols="50" name="comment" form="usrform">
	Enter feedback here...</textarea>
	<br>
	<br>
	
	<h2>Suggestion</h2>
		<textarea rows="4" cols="50" name="comment2" form="usrform">
	Enter suggestion here...</textarea>
	<br>
	<br>
		<tr><td>Date</td>
		<td>
		<form:input path="dof" type="date" required="required" /> </td><!-- bind to user.name-->
		<td><form:errors path="dof" /></td></tr>
	
	<br>
	<br>	
			<td></td>
			<td><input type="submit" value="Submit" /></td> 
	</form:form>
	</center>
	
</body>
</html>