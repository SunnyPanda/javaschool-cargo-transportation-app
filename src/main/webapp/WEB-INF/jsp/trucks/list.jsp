<%--
  Created by IntelliJ IDEA.
  User: kate
  Date: 12.04.18
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
      integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Trucks List</title>
</head>
<body>
<h1>Welcome to the Trucks Page</h1>

<table>
    <tr>
        <td>Reg. Number</td>
        <td>Shift Size</td>
        <td>Capacity</td>
        <td><a href="<c:url value='/edit${truck}'/>">new</a></td>
    </tr>
    <c:forEach items="${trucks}" var="truck">
        <tr>
            <td>${truck.regNumber}</td>
            <td>${truck.shiftSize}</td>
            <td>${truck.capacity}</td>
            <td><a href="<c:url value='/trucks/delete/${truck.id}'/>">delete</a></td>
            <td><a href="<c:url value='/trucks/edit/${truck.id}'/>">edit</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

