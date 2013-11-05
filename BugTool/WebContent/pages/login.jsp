<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
	});
</script>
	<form action="checkUserLogin.html" method="post" id="loginForm">
		<div id="msgid">${message }</div>
		<table>
			<tr>
				<td><spring:message code="login_id" /></td>
				<td><input type="text" name="userName" id="userName" /></td>
			</tr>
			<tr>
				<td><spring:message code="login_password" /></td>
				<td><input type="password" name="pswd" id="pswd" /></td>
			</tr>
			<tr>
				<td><input type="submit"
					value='<spring:message code='submit'/>' id="login" onclick="bugtool.loginPage.checkSubmit"></input></td>
				<td><input type="reset" value='<spring:message code='reset'/>'
					id="" /></td>
			</tr>

		</table>
	</form>
</body>
</html>