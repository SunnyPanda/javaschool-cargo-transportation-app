<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <div class="page-header mt-5">
        <h1>Welcome to the Drivers Page</h1>
    </div>

    <a class="btn btn-primary" href="<c:url value='/drivers/create'/>" role="button">New Driver</a>
    <br/>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th scope="col">Personal Number</th>
            <th scope="col">Last Name</th>
            <th scope="col">First Name</th>
            <th scope="col">Hours/month</th>
            <th scope="col">Status</th>
            <th scope="col">City</th>
            <th scope="col">Truck</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${drivers}" var="driver" varStatus="status">
            <tr>
                <th scope="row">${driver.personalNumber}</th>
                <td>${driver.firstName}</td>
                <td>${driver.lastName}</td>
                <td>${driver.hoursPerMonth}</td>
                <td>${driver.driverStatus}</td>
                <td>${driver.currentCity.name}</td>
                <td>${driver.currentTruck.regNumber}</td>
                <td><a href="<c:url value='/drivers/edit/${driver.id}'/>">edit</a></td>
                <td><a href="<c:url value='/drivers/delete/${driver.id}'/>">delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</t:wrapper>
