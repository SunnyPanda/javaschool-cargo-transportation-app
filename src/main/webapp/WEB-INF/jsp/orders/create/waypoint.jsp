<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    </br>
    <div class="page-header">
        <h2>Waypoints</h2>
    </div>
    <form:form action="/orders/save" method="POST" modelAttribute="order">
        <table>
            <c:forEach items="${order.waypoints}" var="waypoint" varStatus="status">
                <tr>
                    <td>${waypoint.city.name}</td>
                    <td>${waypoint.cargo.name}</td>
                    <td>${waypoint.waypointType.name()}</td>
                </tr>
            </c:forEach>
        </table>


        <table>
            <td><label for="waypoints">Выберите маршрутную точку:</label></td>
            <td>
                    <%--<form:select path="currentCity" items="${cities}" itemLabel="name" itemValue="id"/>--%>
                <form:select path="waypoints" items="${freewaypoints}" itemValue="id" itemLabel="id" multiple="true"/>
                    <%--<form:options items="${freewaypoints}"/>--%>
                    <%--</form:select>--%>
            </td>
            <td><form:errors path="waypoints" cssClass="error"/></td>
            <td colspan="3"><input type="submit" value="Выбрать"/></td>
        </table>
    </form:form>

    <form:form action="/orders/addtruck" method="POST" modelAttribute="order">
        <td colspan="3"><input type="submit" value="Next"/></td>
    </form:form>
</t:wrapper>
