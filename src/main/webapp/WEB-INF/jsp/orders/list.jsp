<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <div class="container">
        <div class="py-5 text-left">
            <h2>Order's List</h2>
            <hr class="mb-4">
        </div>
        <form:form action="/orders/create/number" method="GET">
            <button class="btn btn-primary" type="submit">New Order</button>
        </form:form>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th scope="col">Unique Number</th>
                <th scope="col">Status</th>
                <th scope="col">Waypoints</th>
                <th scope="col">Truck</th>
                <th scope="col">Drivers</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${orders}" var="order" varStatus="status">
                <tr>
                    <th scope="row">${order.uniqueNumber}</th>
                    <td>${order.orderStatus.toString()}</td>
                    <td><a href="<c:url value='/orders/waypoints/${order.id}'/>">waypoints</a></td></td>
                    <td>${order.truck.regNumber}</td>
                    <td><a href="<c:url value='/orders/drivers/${order.id}'/>">drivers</a></td></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</t:wrapper>
