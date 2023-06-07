<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <title>Product</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
    <button class="btn btn-dark" type="button" data-bs-toggle="modal"
            data-bs-target="#addProductModal">
        Add a product
    </button>

    <c:forEach items="${product}" var="product" varStatus="loop">
        <c:if test="${loop.index % 3 == 0}">
            <div class="row gy-3">
        </c:if>

        <div class="col-md-4">
            <div class="card">
                <img src="${product.imageUrl}" class="card-img-top" alt="Product Image">
                <div class="card-body">
                    <h3 class="card-title">${product.productName}</h3>
                    <h4 class="card-title">${product.era.value}</h4>
                    <h5 class="card-text">${product.type.value}</h5>
                    <h2 class="card-text">${product.productPrice}</h2>
                    <p class="card-text">${product.productDescription.length() > 50 ? product.productDescription.substring(0,50).concat("...") : product.productDescription}</p>
                    <a href="#" class="btn btn-primary">View Details</a>
                </div>
            </div>
        </div>

        <c:if test="${(loop.index + 1) % 3 == 0 || loop.last}">
            </div>
        </c:if>
    </c:forEach>
    </div>
</div>

<jsp:include page="addProductModal.jsp"/>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</html>
