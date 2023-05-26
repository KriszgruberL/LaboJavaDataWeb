<%--
  Created by IntelliJ IDEA.
  User: studentdev02
  Date: 10-05-23
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
<%--  <link rel="stylesheet" href="../../styles/style.css">--%>
  <link href="
https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css
" rel="stylesheet">
</head>
<header>

  <nav class="navbar navbar-expand-lg bg-body-tertiary ">
    <div class="container-fluid">
      <a class="navbar-brand" href="index.jsp">Home</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
              data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
              aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="product">Products</a>
          </li>
          <c:if test="${connectedUser == null}">
            <li class="nav-item">
              <a class="nav-link" href="login">Login</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="register">Register</a>
            </li>
          </c:if>
          <c:if test="${connectedUser != null}">
            <li class="nav-item">
              <a class="nav-link" href="logout">Logout</a>
            </li>
          </c:if>

        </ul>
        <form class="d-flex" role="search">
          <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-dark" type="submit">Search</button>
        </form>
      </div>
    </div>
  </nav>


</header>
</html>