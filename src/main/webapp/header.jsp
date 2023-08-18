<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
  <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
    <div>
      <a href="#" class="navbar-brand">Article App</a>
    </div>
    <c:set var = "name" scope = "session" value = "${name}"/>
    <c:if test="${name != null}">
      <ul class="navbar-nav navbar-collapse justify-content-end">
        <li><h3 style="color: white">${name}</h3></li>
        <li><a href="<%= request.getContextPath() %>/logout" class="nav-link">Logout</a></li>
      </ul>
    </c:if>
  </nav>
</header>
