<%--
  Created by IntelliJ IDEA.
  User: kate
  Date: 13.04.18
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
      integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cargo Transportation</title>
</head>
<body>
<h1>Welcome Page</h1>
Go to <a href="<c:url value='/drivers/list' />">Drivers List</a>
<br/>
Go to <a href="<c:url value='/trucks/list' />">Trucks List</a>
</body>
</html>