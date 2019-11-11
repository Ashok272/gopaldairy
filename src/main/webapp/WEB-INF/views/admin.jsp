<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
	<jsp:include page="main.jsp" />
 <center>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h3><a href="/admin/empregister"> add employee</a></h3>
        <h3><a href="/admin/venregister">add vendor</a></h3>
        <h3><a href="/admin/proregister">add product</a></h3>
        <h3><a href="/admin/dsregister"> add delivery boy</a></h3>
        <h3><a href="/admin/showproducts"> show all products</a></h3>
        <h3><a href="/admin/showemployees"> show all employees</a></h3>
        <h3><a href="/admin/showvendors">show all vendors</a></h3>
        <h3><a href="/admin/showdss"> all delivery boys</a></h3>
        <h3><a href="/admin/payven">Pay to Vendor</a></h3>
        <h3><a href="/admin/payemp">Pay to Employee</a></h3>
        <h3><a href="/admin/showlog">Show Payment Log</a></h3>
        <h3><a href="/admin/showproductyettodeliver"> show all orders yet to delivered</a></h3>
        <h3><a href="/admin/showdeliveredproducts">show all delivered orders </a></h3>
        <h3><a href="/admin/showinvoice"> show all invoices</a></h3>
        <h3><a href="/admin/showfeedback">show all feedbacks</a></h3>
        <h3><a href="/admin/showvendortrans">show Daily vendor transactions</a></h3>
        
    </c:if>
 </center>
</body>
</html>
