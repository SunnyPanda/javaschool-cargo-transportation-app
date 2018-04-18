<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    </br>
    <div class="page-header">
        <h2>New Order</h2>
    </div>
    <form:form method="POST" modelAttribute="order">
        <table>
            <tr>
                <td><label for="uniqueNumber">Номер заказа: </label></td>
                <td><form:input path="uniqueNumber" id="uniqueNumber"/></td>
                <td><form:errors path="uniqueNumber" cssClass="error"/></td>
            </tr>
            </br>
                <%--<form:form action="orders/search" method="POST" modelAttribute="order">--%>
                <%--<label for="waypoints">Выберите маршрутную точку:</label>--%>
                <%--<form:select path="waypoints" id="waypoints">--%>
                <%--<form:options items="${}"/>--%>
                <%--</form:select>--%>
                <%--<input type="submit" value="Search"/>--%>
                <%--</form:form>--%>
            <tr>
                <td colspan="3">
                    <input type="submit" value="Register"/>
                </td>
            </tr>
        </table>
    </form:form>
</t:wrapper>

<%--<tr>--%>
<%--<td><label for="driverStatus">Status: </label></td>--%>
<%--<td>--%>
<%--<form:select path="driverStatus" id="driverStatus">--%>
<%--<form:options items="${statusValues}"/>--%>
<%--</form:select>--%>
<%--</td>--%>
<%--<td><form:errors path="driverStatus" cssClass="error"/></td>--%>
<%--</tr>--%>