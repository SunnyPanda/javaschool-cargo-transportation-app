<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <div class="container">
        <div class="py-5 text-left">
            <h2>Edit Driver</h2>
        </div>
        <form:form method="POST" modelAttribute="driver">
            <div class="col-md-8 order-md-1">
            <div class="mb-3">
                <label for="personalNumber">Personal number</label>
                <form:input class="form-control" path="personalNumber" id="personalNumber"/>
                <form:errors path="personalNumber" cssClass="error"/>

            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="firstName">First name</label>
                    <form:input class="form-control" path="firstName" id="firstName"/>
                    <form:errors path="firstName" cssClass="error"/>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="lastName">Last name</label>
                    <form:input class="form-control" path="lastName" id="firstName"/>
                    <form:errors path="lastName" cssClass="error"/>
                </div>
            </div>

            <div class="mb-3">
                <label for="hoursPerMonth">Hours/month</label>
                <form:input class="form-control" path="hoursPerMonth" id="hoursPerMonth"/>
                <form:errors path="hoursPerMonth" cssClass="error"/>
            </div>

            <div class=mb-3">
                <label for="currentCity">City</label>
                    <form:select class="custom-select d-block w-100" path="currentCity">
                        <form:option value="${driver.currentCity}" />
                        <form:options items="${cities}" itemLabel="name" itemValue="id"/>
                    </form:select>
                <%--<form:select class="custom-select d-block w-100" path="currentCity" items="${cities}" itemLabel="name" itemValue="id"/>--%>
            </div>
            <hr class="mb-4">
            <a class="btn btn-secondary" href="/drivers/list" role="button">Back</a>
            <button class="btn btn-primary" type="submit">Update</button>
        </form:form>
    </div>
</t:wrapper>

<%--</br>--%>
<%--<div class="page-header">--%>
<%--<h2>Edit Driver</h2>--%>
<%--</div>--%>
<%--<form:form method="POST" modelAttribute="driver">--%>
<%--<table>--%>
<%--<tr>--%>
<%--<td><label for="personalNumber">Personal Number: </label></td>--%>
<%--<td><form:input path="personalNumber" id="personalNumber"/></td>--%>
<%--<td><form:errors path="personalNumber" cssClass="error"/></td>--%>
<%--</tr>--%>

<%--<tr>--%>
<%--<td><label for="firstName">First Name: </label></td>--%>
<%--<td><form:input path="firstName" id="firstName"/></td>--%>
<%--<td><form:errors path="firstName" cssClass="error"/></td>--%>
<%--</tr>--%>

<%--<tr>--%>
<%--<td><label for="lastName">Last Name: </label></td>--%>
<%--<td><form:input path="lastName" id="lastName"/></td>--%>
<%--<td><form:errors path="lastName" cssClass="error"/></td>--%>
<%--</tr>--%>

<%--<tr>--%>
<%--<td><label for="hoursPerMonth">Hours/month: </label></td>--%>
<%--<td><form:input path="hoursPerMonth" id="hoursPerMonth"/></td>--%>
<%--<td><form:errors path="hoursPerMonth" cssClass="error"/></td>--%>
<%--</tr>--%>
<%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;<td><label for="driverStatus">Status: </label></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;<td>&ndash;%&gt;--%>
<%--&lt;%&ndash;<form:select path="driverStatus" id="driverStatus">&ndash;%&gt;--%>
<%--&lt;%&ndash;<form:options items="${statusValues}"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;</form:select>&ndash;%&gt;--%>
<%--&lt;%&ndash;</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;<td><form:errors path="driverStatus" cssClass="error"/></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
<%--<tr>--%>
<%--<td><label for="currentCity">City: </label>--%>
<%--<td>--%>
<%--<form:select path="currentCity" items="${cities}" itemLabel="name" itemValue="id"/>--%>
<%--</td>--%>
<%--</tr>--%>
<%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;<td><label for="currentTruck">Truck: </label></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;<td><form:input path="currentTruck.regNumber" id="currentTruck"/></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;<td><form:errors path="currentTruck" cssClass="error"/></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
<%--<tr>--%>
<%--<td colspan="3"><input type="submit" value="Update"/></td>--%>
<%--</tr>--%>
<%--</table>--%>
<%--</form:form>--%>