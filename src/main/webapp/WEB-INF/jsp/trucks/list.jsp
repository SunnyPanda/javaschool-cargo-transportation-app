
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <div class="page-header mt-5">
        <h1>Welcome to the Trucks Page</h1>
    </div>
    <br/>
    <table class="table table-striped table-hover">
        <thead>
            <tr>
                <th scope="col">Reg. Number</th>
                <th scope="col">Shift Size</th>
                <th scope="col">Capacity</th>
                <th scope="col">State</th>
                <th scope="col">City</th>
                    <%--<th scope="col">Order</th>--%>
                <th/>
                <th/>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${trucks}" var="truck" varStatus="status">
                <tr>
                    <th scope="row">${truck.regNumber}</th>
                    <td>${truck.shiftSize}</td>
                    <td>${truck.capacity}</td>
                    <td>${truck.truckState}</td>
                    <td>${truck.currentCity.name}</td>
                        <%--<td>${truck.order.id}</td>--%>
                    <td><a href="<c:url value='/trucks/edit/${truck.id}'/>">edit</a></td>
                    <td><a href="<c:url value='/trucks/delete/${truck.id}'/>">delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a class="btn btn-primary" href="<c:url value='/trucks/create'/>" role="button">New Truck</a>
</t:wrapper>

