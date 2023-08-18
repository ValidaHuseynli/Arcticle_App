<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Login Form</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
  <jsp:include page="header.jsp"></jsp:include>
  <div class="container">
    <h1 style="text-align: center">Login Form</h1>
    <h4 style="text-align: center; color: red">${loginError}</h4>
    <div class="row">
      <div class="col-3"></div>
      <div class="col-6">
        <form action="<%=request.getContextPath()%>/login" method="post">

          <div class="form-group">
            <label for="username">User Name:</label>
            <input type="text" class="form-control" id="username" placeholder="User Name" name="username" required>
          </div>

          <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
          </div>

          <button type="submit" class="btn btn-primary">Submit</button>
          <a class="btn btn-secondary" href="index.jsp">Back</a>

        </form>
      </div>
      <div class="col-3"></div>
    </div>
  </div>
  <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>