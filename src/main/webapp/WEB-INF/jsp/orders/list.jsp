<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <div class="page-header mt-5">
        <h1>Welcome to the Orders Page</h1>
    </div>
    <br/>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th scope="col">Unique Number</th>
            <th scope="col">Status</th>
            <th scope="col">Waypoints</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${orders}" var="order" varStatus="status">
            <tr>
                <th scope="row">${order.uniqueNumber}</th>
                <td>${order.orderStatus}</td>
                <td><a href="<c:url value='/orders/waypoints/${order.id}'/>">waypoints</a></td></td>
                <%--<td><a href="<c:url value='/orders/waypoints'/>">waypoints</a></td></td>--%>
                <%--<td>${driver.lastName}</td>--%>
                <%--<td>${driver.hoursPerMonth}</td>--%>
                <%--<td>${driver.driverStatus}</td>--%>
                <%--<td>${driver.currentCity.name}</td>--%>
                <%--<td>${driver.currentTruck.regNumber}</td>--%>
                <%--<td><a href="<c:url value='/drivers/edit/${driver.id}'/>">edit</a></td>--%>
                <%--<td><a href="<c:url value='/drivers/delete/${driver.id}'/>">delete</a></td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</t:wrapper>