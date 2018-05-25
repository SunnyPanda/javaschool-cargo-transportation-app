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
                <h4 class="mb-1">Step 2</h4>
                <form:form action="/orders/create/waypoint" method="POST" modelAttribute="waypoint">
                    <div class="row">
                        <div class="col-md-5 mb-3">
                            <label for="city">City</label>
                            <form:select path="city" items="${city}" itemLabel="name" itemValue="id"/>
                                <%--<div class="invalid-feedback">--%>
                                <%--Please select a valid country.--%>
                                <%--</div>--%>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="cargo">Cargo</label>
                            <form:select path="cargo" items="${cargo}" itemLabel="name" itemValue="id"/>
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
                            <form:select path="waypointType" items="${waypointType}" itemLabel="label"
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
                            <button class="btn btn-primary" type="submit">Add Waypoint</button>
                        </div>

                    </div>

                </form:form>
            </div>
        </div>
    </div>
    </br>
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
    </div>
    <form:errors path="waypoints" cssClass="error"/>

    <form:form action="/orders/addtruck" method="GET" modelAttribute="order">
        <hr class="mb-4">
        <a class="btn btn-primary" href="/orders/create/number" role="button">Previous Step</a>
        <button class="btn btn-primary" type="submit">Next Step</button>
    </form:form>
</t:wrapper>
<%--<form:form action="/orders/save" method="POST" modelAttribute="waypoint">--%>
<%--<table>--%>
<%--<tr>--%>
<%--<td><label for="city">City: </label>--%>
<%--<td>--%>
<%--<form:select path="city" items="${city}" itemLabel="name" itemValue="id"/>--%>
<%--</td>--%>
<%--</tr>--%>

<%--<tr>--%>
<%--<td><label for="cargo">Cargo: </label>--%>
<%--<td>--%>
<%--<form:select path="cargo" items="${cargo}" itemLabel="name" itemValue="id"/>--%>
<%--</td>--%>
<%--</tr>--%>

<%--<tr>--%>
<%--<td><label for="waypointType">Type: </label></td>--%>
<%--<td>--%>
<%--<form:select path="waypointType" items="${waypointType}" itemLabel="label" itemValue="name"/>--%>
<%--</td>--%>
<%--&lt;%&ndash;<td><form:errors path="waypointType" cssClass="error"/></td>&ndash;%&gt;--%>
<%--</tr>--%>

<%--<tr>--%>
<%--<td colspan="3"><input type="submit" value="Add Waypoint"/></td>--%>
<%--</tr>--%>
<%--</table>--%>
<%--&lt;%&ndash;<table>&ndash;%&gt;--%>
<%--&lt;%&ndash;<td><label for="waypoints">Выберите маршрутную точку:</label></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;<td>&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;<form:select path="currentCity" items="${cities}" itemLabel="name" itemValue="id"/>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;<form:select path="waypoints" items="${freewaypoints}" itemValue="id" itemLabel="id" multiple="true"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;<form:options items="${freewaypoints}"/>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;</form:select>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;<td><form:errors path="waypoints" cssClass="error"/></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;<td colspan="3"><input type="submit" value="Выбрать"/></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;</table>&ndash;%&gt;--%>
<%--</form:form>--%>