
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <title>Product</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
    <button class="btn btn-dark" type="button" data-bs-toggle="modal"
            data-bs-target="#addModal">
        Add a product
    </button>
    <br>
    <br>
    <div class="row gy-3">
        <c:forEach items="${product}" var="product">
            <h1>Yo</h1>
        </c:forEach>
    </div>
</div>



</body>

</html>