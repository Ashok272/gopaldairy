<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<jsp:include page="main.jsp" />

	<form:form method="post" modelAttribute="product" action="proregister">
		<table><tr><td>
		Name</td><td>
		<form:input path="name" type="text" required="required"/> </td><!-- bind to user.name-->
		<td><form:errors path="name" /></td></tr>
		
		<tr><td>Vendor Id</td>
		<td>
		<form:select path="vid">
		<c:if test="${!empty allven}">
		<c:forEach items="${allven}" var="ven" varStatus="loop">
		<form:option value="${ven.getVid()}">${ven.getVid()}(${ven.getName()})</form:option>
		</c:forEach>
		</c:if> 
		</form:select>
		</td><!-- bind to user.name-->
		<td><form:errors path="vid" /></td></tr>
		
		
		<tr><td>Product Type</td>
		<td>
		<form:input path="type" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="type" /></td></tr>
		

		
		<tr><td>Quantity In Stock</td>
		<td>
		<form:input path="qinstock" type="number" required="required" min="0"/> </td><!-- bind to user.name-->
		<td><form:errors path="qinstock" /></td></tr>
		
		<tr><td>Price</td>
		<td>
		<form:input path="price" type="number" required="required" min="1"/> </td><!-- bind to user.name-->
		<td><form:errors path="price" /></td></tr>
		
		
		<tr><td>Pack Size</td>
		<td>
		<form:input path="pcksize" type="number" min="0"/> </td><!-- bind to user.name-->
		<td><form:errors path="pcksize" /></td></tr>
		
		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
			</tr>
		<tr><td>${error}</td></tr>
		</table>
	</form:form>