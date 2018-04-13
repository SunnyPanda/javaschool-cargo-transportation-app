<%--
  Created by IntelliJ IDEA.
  User: kate
  Date: 13.04.18
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Create New Truck</title>

    <style>

        .error {
            color: #ff0000;
        }
    </style>

</head>

<body>

<h2>New Truck</h2>

<form:form method="POST" modelAttribute="truck">
    <%--<form:input type="hidden" path="id" id="id"/>--%>
    <table>
        <tr>
            <td><label for="regNumber">Регистрационный номер: </label></td>
            <td><form:input path="regNumber" id="regNumber"/></td>
            <td><form:errors path="regNumber" cssClass="error"/></td>
        </tr>

        <tr>
            <td><label for="shiftSize">Размер смены: </label></td>
            <td><form:input path="shiftSize" id="shiftSize"/></td>
            <td><form:errors path="shiftSize" cssClass="error"/></td>
        </tr>

        <tr>
            <td><label for="capacity">Вместимость: </label></td>
            <td><form:input path="capacity" id="capacity"/></td>
            <td><form:errors path="capacity" cssClass="error"/></td>
        </tr>

        <tr>
            <td colspan="3">
                    <c:choose>
                    <c:when test="${edit}">
                    <input type="submit" value="Update"/>
                    </c:when>
                    <c:otherwise>
                    <input type="submit" value="Register"/>
                    </c:otherwise>
                    </c:choose>
            </td>
        </tr>
    </table>
</form:form>
<br/>
<br/>
Go back to <a href="<c:url value='/trucks/list' />">Trucks List</a>
</body>
</html>