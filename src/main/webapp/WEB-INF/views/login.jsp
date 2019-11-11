<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<title>Custom Login Page</title>

<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
}
</style>
</head>

<body onload='document.loginForm.j_username.focus();'>
	<jsp:include page="main.jsp" />

	<%
		String errorString = (String) request.getAttribute("error");
		if (errorString != null && errorString.trim().equals("true")) {
			out.println("<span class=\"errorblock\">Incorrect login name or password. Please try again");
		}
	%>
<br>
<br>
<br>
	
	<center>
	<form name='loginForm' action="<c:url value='login' />"
					method='POST' class="form-inline">
					<div class="form-group" style="font-size: 22px">
						<label>username:</label> <input type='text' name='username'
							class="form-control" placeholder="username" value=''><br>
					</div>
					<br>
					<div class="form-group" style="font-size: 22px">
						<label>Password:</label> <input type='password' name='password'
							class="form-control" placeholder="password" />
					</div>
					<br> <input name="submit" type="submit"
						class="btn btn-success" value="LogIn" /> <input name="reset"
						type="reset" class="btn btn-success" value="Reset" />

				</form>
	
	
	</center>	
	
	
</body>
</html>