<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="main.jsp" />
	<form:form method="post" modelAttribute="deliveryservice" action="update">
		<table><tr><td>
		Name</td><td>
		<form:input path="name" type="text" required="required"/> </td><!-- bind to user.name-->
		<td><form:errors path="name" /></td></tr>
		
		<tr><td>Phone No</td>
		<td>
		<form:input path="phone_no" type="number" required="required" min="1000000000" max="9999999999"/> </td><!-- bind to user.name-->
		<td><form:errors path="phone_no" /></td></tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
			</tr>
		<tr><td>${error}</td></tr>
		</table>
		<form:hidden path="sid" value="${sid}" />
	</form:form>