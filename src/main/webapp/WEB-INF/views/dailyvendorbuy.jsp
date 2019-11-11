<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="main.jsp" />
	<form:form method="post" modelAttribute="dailyvendorbuy" action="updatedailyvendorbuy">
		<table><tr><td>Vendor ID</td>
		<td>
		<form:select path="vennid">
		<c:if test="${!empty allven}">
		<c:forEach items="${allven}" var="ven" varStatus="loop">
		<form:option value="${ven.getVid()}">${ven.getVid()}(${ven.getName()})</form:option>
		</c:forEach>
		</c:if>
		</form:select>
		</td><!-- bind to user.name -->
		<td><form:errors path="vennid" /></td>
		</tr>
		
		<tr><td>Product ID</td>
		<td>
		<form:select path="proddid">
		<c:if test="${!empty allpro}">
		<c:forEach items="${allpro}" var="pro" varStatus="loop">
		<form:option value="${pro.getProduct_id()}">${pro.getProduct_id()}(${pro.getName() })</form:option>
		</c:forEach>
		</c:if>
		</form:select>
		</td><!-- bind to user.name -->
		<td><form:errors path="proddid" /></td>
		</tr>
		<tr><td>
		Quan</td><td>
		<form:input path="quan" type="number" required="required"/> </td><!-- bind to user.name-->
		<td><form:errors path="quan" /></td></tr>
		
		<tr><td>
		Price</td><td>
		<form:input path="price" type="number" required="required" min="1"/> </td><!-- bind to user.name-->
		<td><form:errors path="price" /></td></tr>
		
		<tr><td>Date</td>
		<td>
		<form:input path="doprodbuy" type="date" required="required"/> </td><!-- bind to user.name-->
		<td><form:errors path="doprodbuy" /></td></tr>
		
		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
			</tr>
		<tr><td>${error}</td></tr>
		</table>
	</form:form>