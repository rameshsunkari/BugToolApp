<%@ page session="true"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Login Success</title>
</head>
<body>

	<h1>${message}</h1>
	<table id="userInfoTable" border="1">
		<tr>
			<td>
				<table border="1">
					<tr>
						<td><spring:message code="first_name" /></td>
						<td>${userInfoObj.FName}</td>
					</tr>
					<tr>
						<td><spring:message code="last_name" /></td>
						<td>${userInfoObj.LName}</td>
					</tr>
					<tr>
						<td><spring:message code="email_id" /></td>
						<td>${userInfoObj.emailid}</td>
					</tr>
					<tr>
						<td><spring:message code="team" /></td>
						<td>${userInfoObj.project}</td>
					</tr>
				</table>
			</td>
			<td><img id="userImagePic" src="<c:url value="/resources/images/test.jpg" />" alt="User Image" /></td>
		</tr>
	</table>
</body>
</html>