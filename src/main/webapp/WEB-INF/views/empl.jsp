<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
<jsp:include page="main.jsp" />

 
    <c:if test="${pageContext.request.userPrincipal.name != null}">

        <h3>
        <a href="/empl/proregister">Click here to add product</a></h3>
        <h3>
        <a href="/empl/showproducts">Click here to show all products</a></h3>
        <h3>
        <a href="/empl/showdeliveredproducts">Click here to show products that are delivered</a></h3>
        <h3>
        <a href="/empl/showproductyettodeliver">Click here to show products that are not delivered</a></h3>
   		 <h3>
        <a href="/empl/emshowfeedback">Click here to show feedback</a></h3>
        <h3>
        <a href="/empl/updatedailyvendorbuy">Click here to buy from vendor  </a></h3>
    </c:if>
</body>
</html>