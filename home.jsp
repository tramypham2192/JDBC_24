<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"></head>
<body>
	<jsp:include page="common/header.jsp"></jsp:include>
        <div class="container col-md-8 col-md-offset-3" style="overflow: auto">
            <h1>dang nhap thanh cong</h1>
            <h2>Welcome ${sessionScope.username}</h2>
        	<session-config>
        		<session-timeout>15</session-timeout>
        	</session-config>
        </div>
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>