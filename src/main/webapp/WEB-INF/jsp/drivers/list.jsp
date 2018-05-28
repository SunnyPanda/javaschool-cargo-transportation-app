<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <div class="container">
        <div class="py-3 text-left">
            <h2>Driver's List</h2>
            <hr class="mb-4">
        </div>

        <%--<a class="btn btn-primary" href="<c:url value='/drivers/create'/>" role="button">New Driver</a>--%>
        <%--<br/>--%>
        <form:form action="/drivers/create" method="GET">
            <button class="btn btn-primary" type="submit">New Driver</button>
        </form:form>

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
                <th scope="col">Editing</th>
                <th scope="col">Deleting</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${drivers}" var="driver" varStatus="status">
                <tr>
                    <th scope="row">${driver.personalNumber}</th>
                    <td>${driver.firstName}</td>
                    <td>${driver.lastName}</td>
                    <td>${driver.hoursPerMonth}</td>
                    <td>${driver.driverStatus.toString()}</td>
                    <td>${driver.currentCity.name}</td>
                    <td>${driver.currentTruck.regNumber}</td>
                    <td><a class="btn btn-secondary" href="/drivers/edit/${driver.id}" role="button">edit</a></td>
                    <td>
                        <a class="btn btn-secondary" href="/drivers/delete/${driver.id}" role="button">delete</a>
                        <form:errors id="delete" cssClass="error" />
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</t:wrapper>
