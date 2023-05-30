<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<form method="post" action="login">
    <label for="login">Login : </label>
    <input type="text" id="login" name="login" value="${login}">

    <label for="password">Password : </label>
    <input type="password" id="password" name="password">

    <span style="color: red">${errorMessage}</span>
    <button class="btn btn-dark" type="submit">Login</button>
</form>

