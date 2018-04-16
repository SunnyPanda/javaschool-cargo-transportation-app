<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:wrapper>
    <form:form method="GET" modelAttribute="order">
        <div class="page-header mt-5">
            <h1>Для заказа </h1>
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
                        <%--<td><a class="btn btn-primary" href="<c:url value='/orders/${order.id}/trucks/add/${truck.id}'/>"--%>
                        <%--role="button">Add</a></td>--%>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form:form>
</t:wrapper>
