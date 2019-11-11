<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<jsp:include page="main.jsp" />

    <c:if test="${pageContext.request.userPrincipal.name != null}">

        <h3><a href="/user/showuserprofile">Show profile</a></h3>
        <h3><a href="/user/update">Edit Profile</a></h3>
        <h3><a href="/user/showinvoice">Show Orders</a></h3>
        <h3><a href="/user/feedback">Give feedback </a></h3>
        
        
    </c:if>
    <table>
<tr>
	<th>Name</th>
	<th>Product Type</th>
	<th>Price</th>
	<th>Pack Size</th>
</tr>
<c:forEach items="${allpro}" var="product">
	<tr>
		<td>${product.getName()}</td>
		<td>${product.getType()}</td>
		<td>${product.getPrice()}</td>
		<td>${product.getPcksize()}</td>
		<c:choose>
		<c:when test="${product.getQinstock()==0}">
		<td>Out of Stock</td>
		</c:when>
		<c:otherwise>
		<td><a href="/user/cart?pid=${product.getProduct_id()}">Add to cart</a></td>
		</c:otherwise>
		</c:choose>
	</tr>
</c:forEach>
</table>
</body>
</html>