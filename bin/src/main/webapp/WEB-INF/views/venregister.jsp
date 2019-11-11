<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<jsp:include page="main.jsp" />

	<form:form method="post" modelAttribute="vendor" action="venregister">
		<table><tr><td>
		Name</td><td>
		<form:input path="name" type="text" required="required"/> </td><!-- bind to user.name-->
		<td><form:errors path="name" /></td></tr>
		
		<tr><td>Address</td>
		<td>
		<form:input path="address" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="address" /></td></tr>
		
		<tr><td>PINCODE</td>
		<td>
		<form:input path="pincode" type="number" required="required" min="100000" max="999999" /> </td><!-- bind to user.name-->
		<td><form:errors path="pincode" /></td></tr>
		
		<tr><td>City</td>
		<td>
		<form:input path="city" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="city" /></td></tr>
		
		<tr><td>State</td>
		<td>
		<form:input path="state" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="state" /></td></tr>
		
		<tr><td>Website</td>
		<td>
		<form:input path="website" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="website" /></td></tr>
		
		<tr><td>Email</td>
		<td>
		<form:input path="email" type="email" required="required"/> </td><!-- bind to user.name-->
		<td><form:errors path="email" /></td></tr>
		<tr><td>Phone no.</td>
		<td>
		<form:input path="phone_no" type="number" required="required" min="1000000000" max="9999999999"/> </td><!-- bind to user.name-->
		<td><form:errors path="phone_no" /></td></tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
			</tr>
		<tr><td>${error}</td></tr>
		</table>
	</form:form>
