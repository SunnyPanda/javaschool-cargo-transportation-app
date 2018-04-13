<%--
  Created by IntelliJ IDEA.
  User: kate
  Date: 12.04.18
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Welcome to the Trucks Page</h1>
<!--<p>Date: <input type="text" id="datepicker"/></p>-->

<table>
    <tr>
        <td>Reg. Number</td>
        <td>Shift Size</td>
        <td>Capacity</td>
    </tr>
    <c:forEach items="${listOfTrucks}" var="truck">
        <tr>
            <td>${truck.regNumber}</td>
            <td>${truck.shiftSize}</td>
            <td>${truck.capacity}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
