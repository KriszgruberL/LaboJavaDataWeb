<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <!--Bootsrap 4 CDN-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!--Custom styles-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<section class="vh-100">
    <div class="container py-1 h-75 mt-2 mx-auto">
        <div class="row d-flex align-items-center justify-content-center h-100 custom-image-placement">
            <div class="col-md-8 col-lg-7 col-xl-6 image-column">
                <img src="${pageContext.request.contextPath}/img/login_.jpg"
                     class="img-fluid custom-rounded-right mx-auto d-block">
            </div>
            <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1 form-column">
                <form action="login" method="post">
                    <h2 class="text-center fw-bold text-primary-emphasis mb-5">Sign in</h2>
                    <!-- Login input -->
                    <div class="form-outline mb-4">
                        <input type="text" id="login" name="login" placeholder="Login" class="form-control form-control-lg" value="${login}"/>
                        <span style="color: red">${errorMessage}</span>
                    </div>

                    <!-- Password input -->
                    <div class="form-outline mb-4">
                        <input type="password" id="password" name="password" placeholder="Password" class="form-control form-control-lg"/>
                        <span style="color: red">${errorMessage}</span>
                    </div>

                    <div class="d-flex justify-content-around align-items-center mb-4">
                        <!-- Checkbox -->
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="" id="form1Example3" checked/>
                            <label class="form-check-label" for="form1Example3"> Remember me </label>
                        </div>
                        <a href="#!" class="text-decoration-none fs-6 ">Forgot password?</a>
                    </div>

                    <!-- Submit button -->
                    <button type="submit" value="login" class="btn btn-primary btn-lg btn-block">Sign in</button>

                    <div class="divider d-flex align-items-center my-4">
                        <p class="text-center fw-bold mx-3 mb-0 text-muted">OR</p>
                    </div>

                    <a class="btn btn-primary btn-lg btn-block" style="background-color: #3b5998" href="#!"
                       role="button">
                        <i class="fab fa-facebook-f me-2"></i> Continue with Facebook
                    </a>
                    <a class="btn btn-primary btn-lg btn-block" style="background-color: #55acee" href="#!"
                       role="button">
                        <i class="fab fa-linkedin me-2"></i> Continue with Linkedin</a>
                </form>
            </div>
        </div>
    </div>
</section>
</body>

