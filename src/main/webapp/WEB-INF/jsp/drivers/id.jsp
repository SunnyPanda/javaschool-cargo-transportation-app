<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:wrapper>
    <div class="page-header mt-5">
        <h1>Welcome to the Drivers Page</h1>
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
                    <%--<c:out value="${driver.personalNumber}" />--%>
                    <%--<th scope="row">${personalNumber}</th>--%>
            </tr>
                <%--<c:forEach items="${drivers}" var="driver" varStatus="status">--%>
                <%--<tr>--%>
                <%--<th scope="row">${driver.personalNumber}</th>--%>
                <%--<td>${driver.firstName}</td>--%>
                <%--<td>${driver.lastName}</td>--%>
                <%--<td>${driver.hoursPerMonth}</td>--%>
                <%--<td>${driver.driverStatus}</td>--%>
                <%--<td>${driver.currentCity.name}</td>--%>
                <%--<td>${driver.currentTruck.regNumber}</td>--%>
                <%--<td><a href="<c:url value='/drivers/edit/${driver.id}'/>">edit</a></td>--%>
                <%--<td><a href="<c:url value='/drivers/delete/${driver.id}'/>">delete</a></td>--%>
                <%--</tr>--%>
                <%--</c:forEach>--%>
            </tbody>
        </table>
    </form:form>
</t:wrapper>
