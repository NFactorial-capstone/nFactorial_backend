<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
	<title>Home</title>

</head>
<body>
	<% request.setCharacterEncoding("UTF-8"); %>
	<h1 class="rainbow-text">
		Hello World! 헬로우 월드!
	</h1>
	
	<form action="food/search" method="GET">
		음식이름: <input type="text" name="foodName">
		<input type="submit" value="검색">
	</form>
	
</body>
</html>
