<%@ tag pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
    <style>
        body  {
            background-image: url("/static/truck.png");
            background-color: #cccccc;
        }
    </style>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <%--<link rel="icon" href="../../../../favicon.ico">--%>

    <title>Cargo Transportation</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value="/static/css/signin.css"/>"/>
    <%--<link rel="stylesheet" href="<c:url value="/static/css/bootstrap.min.css"/>"/>--%>
    <%--<!-- Bootstrap core CSS -->--%>
    <%--<link href="../../../../dist/css/bootstrap.min.css" rel="stylesheet">--%>

    <!-- Custom styles for this template -->
    <%--<link href="signin.css" rel="stylesheet">--%>
</head>

<body class="text-center">

    <main class="container">
        <div class="row">
            <div class="col-md-5 offset-md-3">
                <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
                    <jsp:doBody/>
                </main>
            </div>
        </div>
    </main>
    <%--<footer class="footer">--%>
        <%--<div class="container">--%>
            <%--<span class="text-muted">@Copyright 2018 Kate Kozlova </span>--%>
        <%--</div>--%>
    <%--</footer>--%>
</body>
