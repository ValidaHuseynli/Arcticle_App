<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Article App</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container d-flex flex-column gap-3 pt-5 p-5">

    <div class="container text-center">
        <a href="<%=request.getContextPath()%>/user/article/actions?action=userArticle" class="btn btn-primary">My
            Article</a>
        <a href="<%=request.getContextPath()%>/user/article/actions?action=allArticles" class="btn btn-primary">All
            Article</a>
        <a href="<%=request.getContextPath()%>/user/article/actions?action=new" class="btn btn-success">Add Article</a>

    </div>
    <c:forEach var="article" items="${articles}">
        <div class="article d-flex flex-column gap-3 p-3">
            <div class="title  border-bottom border-dark w-50 pe-5 ps-5 pt-5">
                <h1><c:out value="${article.title}"/></h1>
            </div>
            <div class="article border border-dark pt-5 pb-5 pe-4 ps-4">
                <p><c:out value="${article.article}"/></p>
            </div>
            <div class="d-flex justify-content-between pb-5 pe-4 ">
                <div class="date w-25 border-bottom border-dark">
                    <h4><c:out value="${article.updated_at}"/></h4></div>
                <div class="buttons w-50 d-flex gap-4 justify-content-end">
                    <c:if test="${article.username ==username}">
                        <a href="<%=request.getContextPath()%>/user/article/actions?action=edit&id=<c:out value='${article.id}'/>"
                           class="btn btn-warning w-25">Edit</a>&nbsp;&nbsp;&nbsp;
                        <a href="<%=request.getContextPath()%>/user/article/actions?action=delete&id=<c:out value='${article.id}'/>"
                           class="btn btn-danger w-25">Delete</a>
                    </c:if></div>
            </div>
        </div>

    </c:forEach>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>