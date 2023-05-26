<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<jsp:include page="WEB-INF/pages/header.jsp"/>
<h2 class="text-center">Hello ${connectedUser.username}!</h2>

<div class="row d-flex justify-content-lg-start align-items-lg m-2 h-100">
    <h5 class="fst-italic text-center ">Lorem Ipsum</h5>

    <div class="bg-danger-subtle">
        <figure class="text-center">
            <blockquote class="blockquote">
                <p>A well-known quote, contained in a blockquote element.</p>
            </blockquote>
            <figcaption class="blockquote-footer">
                Someone famous in <cite title="Source Title">Source Title</cite>
            </figcaption>
        </figure>
    </div>


    <div class="card text-white bg-dark text-center w-75" style="border-radius: 15px; margin: 0 auto">
        <div class="card-body ">
            <p class="lead"> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec quis sem congue,
                condimentum ex a, viverra massa. Quisque laoreet ex vitae orci scelerisque, vitae aliquet odio
                condimentum. Etiam tempus erat elit, eget convallis ligula interdum ac. Integer fringilla dignissim
                massa non ullamcorper. Nam a tellus lacus. Donec porttitor ex vel fringilla rhoncus. Proin
                sollicitudin tempor elementum. Cras vel enim ac augue ornare convallis.

                Aliquam erat volutpat. Nam quis risus at neque egestas fermentum. Pellentesque sit amet pharetra
                augue, a congue mauris. Fusce mollis scelerisque pharetra. Sed et semper tellus. Integer fermentum
                risus in est consectetur vehicula. Nunc egestas elit eu purus dictum, eu cursus erat sagittis.
                Aenean nulla purus, ultricies ac odio eget, ultrices porta orci. Curabitur vel hendrerit enim.

                Nunc ac dolor at tortor rhoncus mattis. Aenean viverra leo ac interdum vehicula. Curabitur lacinia
                consequat turpis ac feugiat. Donec porttitor eros nec tellus hendrerit, eget laoreet sem ultrices.
                Nullam pretium finibus vehicula. Maecenas vestibulum accumsan orci et dignissim. Aliquam non
                facilisis turpis, sed condimentum nibh. Quisque ut purus ac sapien euismod tristique. Praesent
                tincidunt, dui quis pretium ornare, magna enim vulputate neque, non molestie quam neque vel odio.
                Integer tellus orci, gravida a luctus at, viverra nec ligula. Ut mollis porta feugiat. Nullam semper
                lacinia euismod. Vestibulum efficitur ipsum eu consequat tempus. Curabitur ullamcorper interdum
                enim, non vestibulum erat mattis non. Vestibulum eget sem eget arcu pharetra pharetra a ut massa.
                Interdum et malesuada fames ac ante ipsum primis in faucibus.

                Fusce ultrices, libero ut finibus rutrum, dui nibh sodales lorem, efficitur ornare lectus turpis ut
                nibh. Pellentesque semper sem quis lectus bibendum pharetra. Mauris eu condimentum dui, sit amet
                pretium est. Cras et lacinia nunc. Duis vulputate venenatis sagittis. Donec non maximus augue. Morbi
                ullamcorper pretium turpis, dictum pellentesque tellus accumsan eu. Praesent quis odio in ex
                accumsan gravida.

                Nam id aliquet nisi. Cras rhoncus sit amet magna vitae dictum. Phasellus orci nisl, porta ut est sit
                amet, mattis sagittis turpis. Proin non tortor quis enim efficitur imperdiet. Maecenas non nisi
                finibus, rutrum diam ac, maximus lacus. Sed ex felis, faucibus vitae lorem ut, volutpat consectetur
                dui. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos
                himenaeos. </p>
        </div>
    </div>
</div>
</body>
</html>