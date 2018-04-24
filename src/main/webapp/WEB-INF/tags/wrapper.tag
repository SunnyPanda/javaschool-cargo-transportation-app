<%@ tag pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Drivers List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value="/static/css/site.css"/>"/>
</head>
<body>
<header>
    <nav class="navbar navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="<c:url value="/"/>">Cargo Transportation</a>
        <form:form action="/logout" method="post">
            <button class="btn btn-outline-danger" type="submit">Выйти</button>
        </form:form>
    </nav>
</header>
<main role="main" class="container">
    <jsp:doBody/>
</main>
<footer class="footer">
    <div class="container">
        <span class="text-muted">@Copyright 2018 Kate Kozlova </span>
    </div>
</footer>
</body>
</html>

