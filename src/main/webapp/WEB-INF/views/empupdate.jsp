<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="main.jsp" />
	<form:form method="post" modelAttribute="employee" action="update">
		<table>		
		<tr><td>
		password</td><td>
		<form:input path="password" type="password" required="required"/> </td><!-- bind to user.name-->
		<td><form:errors path="password" /></td></tr>
		
		<tr><td>Confirm password</td>
		<td>
		<form:input path="mpassword" type="password" required="required"/> </td><!-- bind to user.name-->
		<td><form:errors path="mpassword" /></td></tr>
		
		<tr><td>Name</td>
		<td>
		<form:input path="name" type="text" required="required"/> </td><!-- bind to user.name-->
		<td><form:errors path="name" /></td></tr>
		
		<tr><td>Address</td>
		<td>
		<form:input path="address" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="address" /></td></tr>
		
		<tr><td>City</td>
		<td>
		<form:input path="city" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="city" /></td></tr>
		
		<tr><td>State</td>
		<td>
		<form:input path="state" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="state" /></td></tr>
		
		<tr><td>PINCODE</td>
		<td>
		<form:input path="pincode" type="number" required="required" min="100000" max="999999"/> </td><!-- bind to user.name-->
		<td><form:errors path="pincode" /></td></tr>
		
		<tr><td>Shift Timings</td>
		<td>
		<form:input path="timings" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="timings" /></td></tr>
		
		<tr><td>Phone No.</td>
		<td>
		<form:input path="phone_no" type="number" required="required" min="1000000000" max="9999999999"/> </td><!-- bind to user.name-->
		<td><form:errors path="phone_no" /></td></tr>
		<tr><td>Bank_name</td>
		<td>
		<form:input path="bank_name" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="bank_name" /></td></tr>
		<tr><td>Bank_acc</td>
		<td>
		<form:input path="bank_accno" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="bank_accno" /></td></tr>
		<tr><td>Bank_ifsc</td>
		<td>
		<form:input path="bank_ifsc" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="bank_ifsc" /></td></tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
			</tr>
		<tr><td>${error}</td></tr>
		</table>
		<form:hidden path="username" value="${username}" />
	</form:form>