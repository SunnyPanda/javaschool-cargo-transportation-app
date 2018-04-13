<%--
  Created by IntelliJ IDEA.
  User: kate
  Date: 12.04.18
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
      integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Drivers List</title>
</head>
<body>
    <h1>Welcome to the Drivers Page!</h1>
    <table>
        <tr>
            <td>Personal Number</td>
            <td>Last Name</td>
            <td>First Name</td>
            <td><a href="<c:url value='/drivers/edit${driver}'/>">new</a></td>
        </tr>
        <c:forEach items="${drivers}" var="driver" varStatus="status">
            <tr>
                <td>${driver.personalNumber}</td>
                <td>${driver.lastName}</td>
                <td>${driver.firstName}</td>
                <td><a href="<c:url value='/drivers/delete/${driver.id}'/>">delete</a></td>
                <td><a href="<c:url value='/drivers/edit/${driver.id}'/>">edit</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
