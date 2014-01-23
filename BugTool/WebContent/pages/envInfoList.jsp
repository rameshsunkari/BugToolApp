<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ page language="java" session="true"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Env Info List</title>
</head>
<body>
	<h1>${message}</h1>
	<form action="envList.html" method="get" id="envListForm">
		<a href="envInfoAdd.html" id="envAddLink">Add Environment Details</a>
		<br />
		<table id="envInfoListTable" border="1">
			<tr>
				<td><spring:message code="env_Id" /></td>
				<td><spring:message code="env_name" /></td>
				<td><spring:message code="env_release" /></td>
				<td><spring:message code="env_pswd" /></td>
				<td><spring:message code="env_bugId" /></td>
				<td><spring:message code="env_customer" /></td>
				<td><spring:message code="env_createdby" /></td>
				<td><spring:message code="env_remarks" /></td>
			</tr>
			<c:forEach items="${sessionScope.envInfoList}" var="item">
				<tr>
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td>${item.release}</td>
					<td>${item.username}</td>
					<td>${item.pswd}</td>
					<td>${item.bugid}</td>
					<td>${item.customer}</td>
					<td>${item.createdby}</td>
					<td>${item.remarks}</td>
				</tr>
			</c:forEach>

		</table>
	</form>
</body>
</html>