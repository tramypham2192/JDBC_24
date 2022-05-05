<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:out value="demo JSTL tag" />
	<c:set var="salary" scope="session" value="${4000}" />
	<c:if test = "${salary > 2000}">
		<h1>salary <c:out value="${salary}"/> </h1>	
	</c:if>
</body>
</html>