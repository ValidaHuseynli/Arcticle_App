<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Article APP</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <h2 style="text-align: center">Welcome to Article APP</h2>
    <div class="container text-center">
        <a class="btn btn-success" href="login.jsp">Login</a>
        <a class="btn btn-secondary" href="register.jsp">Signup</a>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>