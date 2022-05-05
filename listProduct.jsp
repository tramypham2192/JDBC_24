<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"></head>

<body>
	<c:out value="demo JSTL tag" />
	<c:set var = "salary" scope = "session" value = "${4000}"/>
	<c:if test = "${salary > 2000 }">
		<h1>demo if</h1>
	</c:if>
	<jsp:include page="common/header.jsp"></jsp:include>
	<div class = "container">
		<h3 class = "text=center">List of products</h3>
		<hr>
		<div class="container text-left">
			<a href="<%=request.getContextPath() %>/list" class="btn btn-success">List products</a>
		</div>
		<br>
		<table class = "table table-bordered">
			<thead>
				<tr>
					<th>Name</th>
					<th>Title</th>
					<th>Date</th>
					<th>Status</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" item="${listProduct}">
					<tr>
						<td><c:out value="${product.name}"/></td>
						<td><c:out value="${product.title}"/></td>
						<td><c:out value="${product.targetDate}"/></td>
						<td><c:out value="${product.status}"/></td>
						<td>
							<a href="#">Edit</a>
							<a href="#">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>