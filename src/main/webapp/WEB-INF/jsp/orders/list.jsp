<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <div class="container">
        <div class="row">
            <div class="col-md-5 mb-3">
                <form:form action="/manager/orders/search" method="POST" modelAttribute="order">
                    <label for="uniqueNumber">Searching for order status</label>
                    <input class="form-control" type="number" path="uniqueNumber" id="uniqueNumber" name="uniqueNumber"
                           placeholder="Enter the order unique number"/>
                    <button class="btn btn-secondary" type="submit">Search</button>
                </form:form>
            </div>
            <%--<div class="col-md-5 mb-3">--%>
                <%--<form:form action="/manager/cargo/search" method="POST" modelAttribute="cargo">--%>
                    <%--<label for="number">Searching for cargo status</label>--%>
                    <%--<input class="form-control" type="number" path="number" id="number" name="number" placeholder="Enter the cargo number"/>--%>
                    <%--<button class="btn btn-secondary" type="submit">Search</button>--%>
                    <%--<p class="text-danger">--%>
                        <%--<form:errors class="text-danger" path="number" cssClass="error"/>--%>
                    <%--</p>--%>
                <%--</form:form>--%>
            <%--</div>--%>
        </div>
        <div class="py-3 text-left">
            <h2>Order's List</h2>
            <hr class="mb-4">
        </div>
        <form:form action="/manager/orders/create/waypoint" method="GET">
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
                    <td><a href="<c:url value='/manager/orders/waypoints/${order.id}'/>">waypoints</a></td></td>
                    <td>${order.truck.regNumber}</td>
                    <td><a href="<c:url value='/manager/orders/drivers/${order.id}'/>">drivers</a></td></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</t:wrapper>
