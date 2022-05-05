<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@taglib prefix="ex" uri="WEB-INF/custom.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ex:Hello>
		custom tag body
	</ex:Hello>
	<c:set var = "Amount" value = "12345.123" />
	<fmt:parseNumber var = "j" type="number" value = "${Amount}"> </fmt:parseNumber>
	<p>Amount: <c:out value = "${j}"></c:out></p>
	<fmt:parseNumber var="j" type="number" integerOnly="true" value="${Amount}"></fmt:parseNumber>
	<p>Amount: <c:out value="${j}"></c:out></p>
	
	
</body>
</html>