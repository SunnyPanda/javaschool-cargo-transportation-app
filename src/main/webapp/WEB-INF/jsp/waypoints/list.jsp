<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <div class="page-header mt-5">
        <h1>Welcome to the Waypoints Page</h1>
    </div>
    <br/>
    <a class="btn btn-primary" href="<c:url value='/manager/waypoints/create'/>" role="button">New Waypoint</a>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th scope="col">City</th>
            <th scope="col">Cargo</th>
            <th scope="col">Type</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${waypoints}" var="waypoint" varStatus="status">
            <tr>
                <td>${waypoint.city.name}</td>
                <td>${waypoint.cargo.name}</td>
                <td>${waypoint.waypointType}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</t:wrapper>
