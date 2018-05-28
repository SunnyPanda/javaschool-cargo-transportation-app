<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <div class="container">
        <div class="py-5 text-left">
            <h2>New Order Form</h2>
        </div>

        <div class="row">
            <div class="col-md-8 order-md-1">
                <h4 class="mb-1">Step 1</h4>
                <hr class="mb-4">
                <form:form action="/manager/orders/create/waypoint" method="POST" modelAttribute="waypoint">
                    <div class="row">
                        <div class="col-md-5 mb-3">
                            <label for="city">City</label>
                            <form:select class="custom-select d-block w-100" path="city" items="${city}" itemLabel="name" itemValue="id"/>
                                <%--<div class="invalid-feedback">--%>
                                <%--Please select a valid country.--%>
                                <%--</div>--%>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="cargo">Cargo</label>
                            <form:select class="custom-select d-block w-100" path="cargo" items="${cargo}" itemLabel="name" itemValue="id"/>
                                <%--<form:select path="cargo">--%>
                                <%--<form:option value="Select.."/>--%>
                                <%--<form:options items="${cargo}" itemLabel="name" itemValue="id"/>--%>
                                <%--</form:select>--%>
                                <%--<div class="invalid-feedback">--%>
                                <%--Please provide a valid state.--%>
                                <%--</div>--%>
                        </div>
                        <div class="col-md-3 mb-3">
                            <label for="waypointType">Type</label>
                            <form:select class="custom-select d-block w-100" path="waypointType" items="${waypointType}" itemLabel="label"
                                         itemValue="name"/>
                                <%--<form:select path="waypointType">--%>
                                <%--<form:option value="Select.."/>--%>
                                <%--<form:options items="${waypointType}" itemLabel="label" itemValue="name"/>--%>
                                <%--</form:select>--%>

                                <%--<div class="invalid-feedback">--%>
                                <%--Zip code required.--%>
                                <%--</div>--%>
                        </div>
                        <div class="col-md-3 mb-3">
                            <button class="btn btn-success" type="submit">Add Waypoint</button>
                        </div>

                    </div>
                    <%--<div class="alert alert-danger" role="alert">--%>
                        <%--<form:errors path="${order.waypoints}" cssClass="error"/>--%>
                    <%--</div>--%>
                    <%--<p class="text-danger">--%>
                        <%--<form:errors path="" cssClass="error"/>--%>
                    <%--</p>--%>

                </form:form>

            </div>

        </div>
        <div class="page-header">
            <h2>Waypoints</h2>
        </div>
        <div class="table-view">
            <table class="table table-striped table-hover">
                <c:forEach items="${order.waypoints}" var="waypoint" varStatus="status">
                    <tr>
                        <td>${waypoint.city.name}</td>
                        <td>${waypoint.cargo.name}</td>
                        <td>${waypoint.waypointType.name()}</td>
                    </tr>
                </c:forEach>
            </table>
            <div class="invalid-feedback">
                <form:errors path="${order.waypoints}" cssClass="error"/>
                </div>
            <%--<p class="text-danger">--%>
                <%--<form:errors path="${order.waypoints}" cssClass="error"/>--%>
            <%--</p>--%>
        </div>
        <form:form action="/manager/orders/addtruck" method="GET" modelAttribute="order">
            <hr class="mb-4">
            <a class="btn btn-secondary" href="/manager/orders/list" role="button">Previous Step</a>
            <button class="btn btn-primary" type="submit">Next Step</button>
        </form:form>
    </div>
</t:wrapper>