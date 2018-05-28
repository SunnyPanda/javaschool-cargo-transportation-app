<%@ tag pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <style>
        body  {
            background-color: coral;
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
        <a class="navbar-brand" href="<c:url value="/"/>">Cargo Transportation</a>
        <form:form action="/logout" method="post">
            <button class="btn btn-outline-danger" type="submit">Выйти</button>
        </form:form>
    </nav>

</header>

<main class="container">
    <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">
                <ul class="nav flex-column">
                    <%--<li class="nav-item">--%>
                        <%--<a class="nav-link active" href="/">--%>
                            <%--<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"--%>
                                 <%--fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"--%>
                                 <%--stroke-linejoin="round" class="feather feather-home">--%>
                                <%--&lt;%&ndash;<path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<polyline points="9 22 9 12 15 12 15 22"></polyline>&ndash;%&gt;--%>
                            <%--</svg>--%>
                            <%--Home <span class="sr-only">(current)</span>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <li class="nav-item">
                        <a class="nav-link" href="/manager/orders/list">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                 fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                 stroke-linejoin="round" class="feather feather-file">
                                <%--<path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path>--%>
                                <%--<polyline points="13 2 13 9 20 9"></polyline>--%>
                            </svg>
                            Orders
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/manager/drivers/list">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                 fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                 stroke-linejoin="round" class="feather feather-shopping-cart">
                                <%--<circle cx="9" cy="21" r="1"></circle>--%>
                                <%--<circle cx="20" cy="21" r="1"></circle>--%>
                                <%--<path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path>--%>
                            </svg>
                            Drivers
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/manager/trucks/list">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                 fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                 stroke-linejoin="round" class="feather feather-users">
                                <%--<path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path>--%>
                                <%--<circle cx="9" cy="7" r="4"></circle>--%>
                                <%--<path d="M23 21v-2a4 4 0 0 0-3-3.87"></path>--%>
                                <%--<path d="M16 3.13a4 4 0 0 1 0 7.75"></path>--%>
                            </svg>
                            Trucks
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/manager/cargo/list">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                 fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                 stroke-linejoin="round" class="feather feather-bar-chart-2">
                                <%--<line x1="18" y1="20" x2="18" y2="10"></line>--%>
                                <%--<line x1="12" y1="20" x2="12" y2="4"></line>--%>
                                <%--<line x1="6" y1="20" x2="6" y2="14"></line>--%>
                            </svg>
                            Cargo
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/manager/cities/list">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                 fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                 stroke-linejoin="round" class="feather feather-layers">
                                <%--<polygon points="12 2 2 7 12 12 22 7 12 2"></polygon>--%>
                                <%--<polyline points="2 17 12 22 22 17"></polyline>--%>
                                <%--<polyline points="2 12 12 17 22 12"></polyline>--%>
                            </svg>
                            Cities
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/manager/waypoints/list">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                 fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                 stroke-linejoin="round" class="feather feather-layers">
                                <%--<polygon points="12 2 2 7 12 12 22 7 12 2"></polygon>--%>
                                <%--<polyline points="2 17 12 22 22 17"></polyline>--%>
                                <%--<polyline points="2 12 12 17 22 12"></polyline>--%>
                            </svg>
                            Waypoints
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

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

