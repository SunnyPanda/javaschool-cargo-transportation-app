<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th scope="col">Unique Number</th>
            <th scope="col">Waypoints</th>
            <th scope="col">Truck</th>
            <th scope="col">Drivers</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">${order.uniqueNumber}</th>
            <td><a href="<c:url value='/orders/waypoints'/>">waypoints</a></td>
            </td>
            <td>${order.truck.regNumber}</td>
            <td><a href="<c:url value='/orders/drivers'/>">drivers</a></td>
            </td>
        </tr>
        </tbody>
    </table>
    <form:form action="/orders/save" method="GET" modelAttribute="order">
        <hr class="mb-4">
        <a class="btn btn-secondary" href="/orders/adddriver" role="button">Previous Step</a>
        <button class="btn btn-primary" type="submit">Finish</button>
    </form:form>
</t:wrapper>