<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    </br>
    <div class="page-header">
        <h2>Hillo</h2>
    </div>
    <form:form method="POST" modelAttribute="order">
        <table>
            <td><label for="waypoints">Выберите маршрутную точку:</label></td>
            <td><form:select path="waypoints" id="waypoints">
                <form:options items="${waypoints}"/>
            </form:select></td>
    <%--<td colspan="3"><input type="submit" value="Выбрать"/></td>--%>
    <%--</form:form>--%>
    <%--</tr>--%>
    <%--</br>--%>
    <%--<tr>--%>
    <%--<td colspan="3">--%>
    <%--<input type="submit" value="Next"/>--%>
    <%--</td>--%>
    <%--</tr>--%>
    <%--<tr>--%>

    <%--<td><label for="waypoints">Выберите маршрутную точку:</label></td>--%>
    <%--<td><form:select path="waypoints" id="waypoints">--%>
    <%--<form:options items="${waypoints}"/>--%>
    <%--</form:select></td>--%>
    <%--<td colspan="3"><input type="submit" value="Выбрать"/></td>--%>
    <%--</form:form>--%>
    <%--</tr>--%>

    <%--<form:form method="POST" modelAttribute="order">--%>
    <%--<tr>--%>
    <%--<td colspan="3">--%>
    <%--<input type="submit" value="Register"/>--%>
    <%--</td>--%>
    <%--</tr>--%>
    </table>
</form:form>
</t:wrapper>
