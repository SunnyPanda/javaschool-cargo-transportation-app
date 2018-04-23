<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:wrapper>
    <div class="page-header mt-5">
        <h1>Driver</h1>
    </div>
    <br/>
    <form:form method="GET" modelAttribute="driver">
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th scope="col">Personal Number</th>
                <th scope="col">Co-drivers</th>
                <th scope="col">Truck</th>
                <th scope="col">Order</th>
                <th scope="col">Waypoints</th>
            </tr>
            </thead>
            <tbody>
                <%--<c:set "driver" scope="session" value="driver" />--%>
            <tr>
                <td>${driver.personalNumber}</td>
                <td>
                    <c:forEach items="${coDrivers}" var="coDriver" varStatus="status">
                        ${coDriver.personalNumber}
                    </c:forEach>
                </td>
                <td>${driver.currentTruck.regNumber}</td>
                <td>${driver.order.uniqueNumber}</td>
                <td><a href="<c:url value='/orders/waypoints/${driver.order.id}'/>">waypoints</a></td>
                </td>
            </tr>
            </tbody>
        </table>
    </form:form>
    <form:form method="POST" modelAttribute="driver" action="/drivers/id/shiftbegin">
        <td colspan="3"><input type="submit" value="Заступил в смену"/></td>
    </form:form>
    <form:form method="POST" modelAttribute="driver" action="/drivers/id/confirm">
        <tr>
            <td>
                <form:select path="driverStatus">
                    <form:option value="BEHIND_THE_WHEEL">За рулём</form:option>
                    <form:option value="IN_SHIFT">Второй водитель</form:option>
                    <form:option value="IN_SHIFT">Погрузочно-разгрузочные работы</form:option>
                    <form:option value="IN_SHIFT">Отдых</form:option>
                </form:select>
            </td>
            <td colspan="3"><input type="submit" value="Confirm"/></td>
        </tr>
    </form:form>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th scope="col">Cargo</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    <c:forEach items="${waypoints}" var="waypoint" varStatus="status">
                        ${waypoint.cargo.number}
                        ${waypoint.cargo.name}
                    <form:form method="POST" modelAttribute="driver" action="/drivers/id/load/${waypoint.cargo.id}">
                <td colspan="1"><input type="submit" value="Получил"/></td>
                </form:form>
                <form:form method="POST" modelAttribute="driver" action="/drivers/id/unload/${waypoint.cargo.id}">
                    <td colspan="1"><input type="submit" value="Выгрузил"/></td>
                </form:form>
                    </c:forEach>
                </td>
            </tr>
            </tbody>
        </table>
    <form:form method="POST" modelAttribute="driver" action="/drivers/id/shiftend">
        <td colspan="3"><input type="submit" value="Окончил смену"/></td>
    </form:form>
</t:wrapper>

<%--<tr>--%>
<%--<td colspan="3">--%>
<%--<c:choose>--%>
<%--<c:when test="${begin}">--%>
<%--<input type="submit" value="Update"/>--%>
<%--</c:when>--%>
<%--<c:otherwise>--%>
<%--<input type="submit" value="Register"/>--%>
<%--</c:otherwise>--%>
<%--</c:choose>--%>
<%--</td>--%>
<%--</tr>--%>