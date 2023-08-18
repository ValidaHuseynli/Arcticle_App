<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Register Form</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
  <h2 style="text-align: center">User Register Form</h2>
  <div class="row">
    <div class="col-3"></div>
    <div class="col-6">
      <form action="<%=request.getContextPath()%>/register" method="post">

        <div class="form-group">
          <label for="name">First Name:</label>
          <input type="text" class="form-control" id="name" placeholder="First Name" name="name" required>
        </div>

        <div class="form-group">
          <label for="surname">Last Name:</label>
          <input type="text" class="form-control" id="surname" placeholder="Last Name" name="surname" required>
        </div>

        <div class="form-group">
          <label for="username">User Name:</label>
          <input type="text" class="form-control" id="username" placeholder="User Name" name="username" required>
        </div>

        <div class="form-group">
          <label for="password">Password:</label>
          <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
    </div>
    <div class="col-3"></div>
  </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
