<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="main.jsp" />
	<form:form method="post" modelAttribute="paylog" action="payVen">
		<table><tr><td>Vendor ID</td>
		<td>
		<form:select path="Ven_id">
		<c:if test="${!empty allVen}">
		<c:forEach items="${allVen}" var="Ven" varStatus="loop">
		<form:option value="${Ven.getMid()}">${Ven.getMid()}(${Ven.getName()})</form:option>
		</c:forEach>
		</c:if>
		</form:select>
		</td><!-- bind to user.name -->
		<td><form:errors path="Ven_id" /></td>
		</tr>
		
		<tr><td>
		Amount</td><td>
		<form:input path="amount" type="number" required="required" min="1"/> </td><!-- bind to user.name-->
		<td><form:errors path="amount" /></td></tr>
		
		<tr><td>Date</td>
		<td>
		<form:input path="dop" type="date" required="required"/> </td><!-- bind to user.name-->
		<td><form:errors path="dop" /></td></tr>
		
		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
			</tr>
		<tr><td>${error}</td></tr>
		</table>
	</form:form>
