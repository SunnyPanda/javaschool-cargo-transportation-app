<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <div class="page-header mt-5">
        <h1>Waypoints for This Order</h1>
    </div>
    <br/>
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
                <td>${waypoint.waypointType.toString()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</t:wrapper>