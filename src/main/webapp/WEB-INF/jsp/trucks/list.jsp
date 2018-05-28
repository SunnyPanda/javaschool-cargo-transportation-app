
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <div class="container">
        <div class="py-3 text-left">
            <h2>Truck's List</h2>
            <hr class="mb-4">
        </div>
        <%--<a class="btn btn-primary" href="<c:url value='/trucks/create'/>" role="button">New Truck</a>--%>
        <form:form action="/manager/trucks/create" method="GET">
            <button class="btn btn-primary" type="submit">New Truck</button>
        </form:form>
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th scope="col">Reg. Number</th>
                    <th scope="col">Shift Size</th>
                    <th scope="col">Capacity</th>
                    <th scope="col">State</th>
                    <th scope="col">City</th>
                    <th scope="col">Editing</th>
                    <th scope="col">Deleting</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${trucks}" var="truck" varStatus="status">
                    <tr>
                        <th scope="row">${truck.regNumber}</th>
                        <td>${truck.shiftSize}</td>
                        <td>${truck.capacity}</td>
                        <td>${truck.truckState.toString()}</td>
                        <td>${truck.currentCity.name}</td>
                        <td><a class="btn btn-secondary" href="/manager/trucks/edit/${truck.id}" role="button">edit</a></td>
                        <td><a class="btn btn-secondary" href="/manager/trucks/delete/${truck.id}" role="button">delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</t:wrapper>

