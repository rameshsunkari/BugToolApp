<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<script>
		$(function() {
			$("#menu").menu();
		});
	</script>
	<script type="text/javascript" src="<c:url value="/resources/javascript/ui/jquery.ui.core.js"/>"> </script>
	<script type="text/javascript" src="<c:url value="/resources/javascript/ui/jquery.ui.widget.js"/>"> </script>
	<script type="text/javascript" src="<c:url value="/resources/javascript/ui/jquery.ui.position.js"/>"> </script>
	<script type="text/javascript" src="<c:url value="/resources/javascript/ui/jquery.ui.menu.js"/>"> </script>

	<ul id="menu">
		<li><a href="envInfoList.html" id="envLink">Environments</a></li>
		<li><a href="bugInfoList.html"
			id="bugDetailLink">Bug Detail</a></li>
		<li><a href="dbInfoList.html"
			id="dbInfoLink">DB Link</a></li>
		<li><a href="logout.html" id="logoutLink">Logout</a></li>

	</ul>
</body>
</html>