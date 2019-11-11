<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
	<jsp:include page="main.jsp" />
 
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h3><a href="/dbms/admin/empregister">Click here to add employee</a></h3>
        <h3><a href="/dbms/admin/venregister">Click here to add vendor</a></h3>
        <h3><a href="/dbms/admin/proregister">Click here to add product</a></h3>
        <h3><a href="/dbms/admin/dsregister">Click here to add delivery service</a></h3>
        <h3><a href="/dbms/admin/showproducts">Click here to show all products</a></h3>
        <h3><a href="/dbms/admin/showemployees">Click here to show all employees</a></h3>
        <h3><a href="/dbms/admin/showvendors">Click here to show all vendors</a></h3>
        <h3><a href="/dbms/admin/showdss">Click here to show all delivery services</a></h3>
        <h3><a href="/dbms/admin/payven">Pay to Vendor</a></h3>
        <h3><a href="/dbms/admin/payemp">Pay to Employee</a></h3>
        <h3><a href="/dbms/admin/showlog">Show Payment Log</a></h3>
        <h3><a href="/dbms/admin/showproductyettodeliver">Click here to show all orders not delivered</a></h3>
        <h3><a href="/dbms/admin/showdeliveredproducts">Click here to show all orders delivered</a></h3>
        <h3><a href="/dbms/admin/showinvoice">Click here to show all invoices</a></h3>
    </c:if>
</body>
</html>
