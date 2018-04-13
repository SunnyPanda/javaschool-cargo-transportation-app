<%--
  Created by IntelliJ IDEA.
  User: kate
  Date: 13.04.18
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Create New Driver</title>

    <style>

        .error {
            color: #ff0000;
        }
    </style>

</head>

<body>

<h2>New Driver</h2>

<form:form method="POST" modelAttribute="driver">
    <%--<form:input type="hidden" path="id" id="id"/>--%>
    <table>
        <tr>
            <td><label for="personalNumber">Personal Number: </label></td>
            <td><form:input path="personalNumber" id="personalNumber"/></td>
            <td><form:errors path="personalNumber" cssClass="error"/></td>
        </tr>

        <tr>
            <td><label for="firstName">First Name: </label></td>
            <td><form:input path="firstName" id="firstName"/></td>
            <td><form:errors path="firstName" cssClass="error"/></td>
        </tr>

        <tr>
            <td><label for="lastName">Last Name: </label></td>
            <td><form:input path="lastName" id="lastName"/></td>
            <td><form:errors path="lastName" cssClass="error"/></td>
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
                <%--<input type="submit" value="Register"/>--%>
            </td>
        </tr>
    </table>
</form:form>
<br/>
<br/>
Go back to <a href="<c:url value='/' />">Drivers List</a>
</body>
</html>