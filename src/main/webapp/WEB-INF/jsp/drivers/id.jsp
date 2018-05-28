<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:driverwrapper>
    <div class="page-header mt-5">
        <h1>Driver ${driver.personalNumber}</h1>
    </div>
    <c:choose>
        <c:when test="${message=='no'}">
            <td>You do not have current orders</td>
            <br/>
        </c:when>
        <c:otherwise>
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
                        <td><a href="<c:url value='/drivers/waypoints/${driver.id}'/>">waypoints</a></td>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form:form>
            <div>
                <form:form method="POST" modelAttribute="driver" action="/drivers/id/shiftbegin">
                    <button class="btn btn-primary" type="submit">Shift begin</button>
                </form:form>
            </div>

            <form:form method="POST" modelAttribute="driver" action="/drivers/id/confirm">
                <tr>
                    <td>
                        <form:select class="custom-select col-md-3 mb-3" path="driverStatus">
                            <form:option value="BEHIND_THE_WHEEL">Behind the wheel</form:option>
                            <%--<form:option value="IN_SHIFT">Второй водитель</form:option>--%>
                            <%--<form:option value="IN_SHIFT">Погрузочно-разгрузочные работы</form:option>--%>
                            <form:option value="IN_SHIFT">Rest</form:option>
                        </form:select>
                    </td>
                    <button class="btn btn-success" type="submit">Confirm</button>
                </tr>
            </form:form>
            <h5>Cargo</h5>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th scope="col">Number</th>
                    <th scope="col">Name</th>
                    <th scope="col">Receiving</th>
                    <th scope="col">Delivery</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${waypoints}" var="waypoint" varStatus="status">
                    <tr>
                        <th scope="row">${waypoint.cargo.number}</th>
                        <td>${waypoint.cargo.name}</td>
                        <td><form:form method="POST" modelAttribute="driver" action="/drivers/id/load/${waypoint.cargo.id}">
                            <button class="btn btn-secondary" type="submit">Received</button>
                        </form:form></td>
                        <td> <form:form method="POST" modelAttribute="driver" action="/drivers/id/unload/${waypoint.cargo.id}">
                            <button class="btn btn-secondary" type="submit">Delivered</button>
                        </form:form></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div>
                <form:form method="POST" modelAttribute="driver" action="/drivers/id/shiftend">
                    <button class="btn btn-primary" type="submit">Shift End</button>
                </form:form>
            </div>
        </c:otherwise>
    </c:choose>
</t:driverwrapper>

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