<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <div class="page-header mt-5">
        <h1>Drivers</h1>
    </div>
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
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <hr class="mb-4">
    <a class="btn btn-primary" href="/manager/orders/list" role="button">Back</a>
</t:wrapper>