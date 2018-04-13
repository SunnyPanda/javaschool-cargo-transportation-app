<%--
  Created by IntelliJ IDEA.
  User: kate
  Date: 12.04.18
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
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
            <td><a href="<c:url value='/edit${driver}'/>">new</a></td>
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

<%--<!DOCTYPE html>--%>
<%--<!--<html lang="en" xmlns:th="http://www.thymeleaf.org">-->--%>
<%--<head>--%>
    <%--<meta charset="utf-8"/>--%>
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge"/>--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1"/>--%>

    <%--<title>Drivers</title>--%>

    <%--<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/ui-darkness/jquery-ui.css"/>--%>
    <%--<link rel="stylesheet" href="/css/site.css"/>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Welcome to the Drivers Page</h1>--%>
<%--<!--<p>Date: <input type="text" id="datepicker"/></p>-->--%>

<%--<table>--%>
    <%--<tr>--%>
        <%--<td>Personal Number</td>--%>
        <%--<td>Last Name</td>--%>
        <%--<td>First Name</td>--%>
    <%--</tr>--%>
    <%--<tr th:each="driver: ${listOfDrivers}">--%>
        <%--<td th:text="${driver.personalNumber}">Personal Number</td>--%>
        <%--<td th:text="${driver.lastName}">Last Name</td>--%>
        <%--<td th:text="${driver.firstName}">First Name</td>--%>
    <%--</tr>--%>
<%--</table>--%>
<%--</body>--%>
<%--</html>--%>