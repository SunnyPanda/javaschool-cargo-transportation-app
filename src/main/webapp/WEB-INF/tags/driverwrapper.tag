<%@ tag pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <style>
        body  {
            /*background-image: url("/static/truck.png");*/
            background-color: #9fcdff;
        }
        #map {
            height: 45%;
            float: left;
            width: 100%;
            height: 45%;
        }
    </style>
    <title>Cargo Transportation</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
          integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value="/static/css/site.css"/>"/>
    <script src="/static/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<header>
    <nav class="navbar navbar-dark fixed-top bg-dark">
        <a class="navbar-brand">Cargo Transportation</a>
        <form:form action="/logout" method="post">
            <button class="btn btn-outline-danger" type="submit">Выйти</button>
        </form:form>
    </nav>

</header>

<main class="container">
    <div class="row">
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
            <jsp:doBody/>
        </main>

    </div>
</main>


<footer class="footer">
    <div class="container">
        <span class="text-muted">@Copyright 2018 Kate Kozlova </span>
    </div>
</footer>
</body>
</html>

