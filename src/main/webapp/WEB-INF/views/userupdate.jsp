<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="main.jsp" />

	<form:form method="post" modelAttribute="user" action="update">
		<table>
		
		<tr><td>
		password</td><td>
		<form:input path="password" type="password" required="required"/> </td>
		<td><form:errors path="password" /></td></tr>
		
		<tr><td>Confirm password</td>
		<td>
		<form:input path="mpassword" type="password" required="required"/> </td>
		<td><form:errors path="mpassword" /></td></tr>
		
		<tr><td>Name</td>
		<td>
		<form:input path="name" type="text" required="required"/> </td>
		<td><form:errors path="name" /></td></tr>
		
		<tr><td>Address</td>
		<td>
		<form:input path="address" type="text" /> </td>
		<td><form:errors path="address" /></td></tr>
		
		<tr><td>City</td>
		<td>
		<form:input path="city" type="text" /> </td>
		<td><form:errors path="city" /></td></tr>
		
		<tr><td>State</td>
		<td>
		<form:input path="state" type="text" /> </td>
		<td><form:errors path="state" /></td></tr>
		
		<tr><td>PINCODE</td>
		<td>
		<form:input path="pincode" type="number"/> </td>
		<td><form:errors path="pincode" /></td></tr>
		
		<tr><td>Email</td>
		<td>
		<form:input path="email" type="email" required="required"/> </td>
		<td><form:errors path="email" /></td></tr>
		
		<tr><td>Phone No.</td>
		<td>
		<form:input path="phone_no" type="number" required="required" /> </td>
		<td><form:errors path="phone_no" /></td></tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
			</tr>
		<tr><td>${error}</td></tr>
		</table>
		<form:hidden path="username" value="${username}" />
	</form:form>