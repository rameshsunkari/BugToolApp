<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>

</head>
<body>
<script type="text/javascript" src="<c:url value="/resources/javascript/loginPage.js" />"> </script>
	
	<script type="text/javascript" src="<c:url value="/resources/javascript/jquery-1.9.1.js" />"> </script>
	<script type="text/javascript" src="<c:url value="/resources/javascript/ui/jquery.ui.core.js" />"> </script>
	<script type="text/javascript" src="<c:url value="/resources/javascript/ui/jquery.ui.widget.js" />"> </script>
	<script type="text/javascript" src="<c:url value="/resources/javascript/ui/jquery.ui.button.js" />"> </script>
<script>
	$(function() {
		$( "input[type=submit], a, button" )
			.button();
		$( "input[type=reset], a, button" )
			.button();
		$("#login").click(bugtool.loginPage.checkSubmit);
	});
</script>
	<form:form modelAttribute="userInfo" method="post" action="checkLogin.html" id="loginForm">
		<h1 id="msgid">${message }</h1>
		<table>
			<tr>
				<td><spring:message code="login_id" /></td>
				<td><form:input path="emailid" id="userName"/>*</td>
			</tr>
			<tr>
				<td><spring:message code="login_password" /></td>
				<td><form:password path="pswd" id="pswd" />*</td>
			</tr>
			<tr>
				<td><input type="submit"
					value='<spring:message code='submit'/>' id="login"></input></td>
				<td><input type="reset" value='<spring:message code='reset'/>'
					id="" /></td>
			</tr>

		</table>
	</form:form>
</body>
</html>