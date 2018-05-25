<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    </br>
    <div class="page-header">
        <h2>New Driver</h2>
    </div>
    <form:form method="POST" modelAttribute="driver">
        <div class="col-md-8 order-md-1">
        <%--<form class="needs-validation" novalidate="">--%>
        <div class="mb-3">
            <label for="personalNumber">Unique number <span class="text-muted">(Optional)</span></label>
                <%--<input type="email" class="form-control" id="email" placeholder="you@example.com">--%>
            <form:input class="form-control" path="personalNumber" id="personalNumber"/>
            <form:errors path="personalNumber" cssClass="error"/>
                <%--<div class="invalid-feedback">--%>
                <%--Please enter a valid email address for shipping updates.--%>
                <%--</div>--%>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="firstName">First name</label>
                    <%--<input type="text" class="form-control" id="firstName" placeholder="" value="" required="">--%>
                <form:input class="form-control" path="firstName" id="firstName"/>
                <form:errors path="firstName" cssClass="error"/>
                    <%--<div class="invalid-feedback">--%>
                    <%--Valid first name is required.--%>
                    <%--</div>--%>
            </div>
            <div class="col-md-6 mb-3">
                <label for="lastName">Last name</label>
                    <%--<input type="text" class="form-control" id="lastName" placeholder="" value="" required="">--%>
                <form:input class="form-control" path="lastName" id="firstName"/>
                <form:errors path="lastName" cssClass="error"/>
                <div class="invalid-feedback">
                    Valid last name is required.
                </div>
            </div>
        </div>

        <%--<div class="mb-3">--%>
        <%--<label for="username">Username</label>--%>
        <%--<div class="input-group">--%>
        <%--<div class="input-group-prepend">--%>
        <%--<span class="input-group-text">@</span>--%>
        <%--</div>--%>
        <%--<input type="text" class="form-control" id="username" placeholder="Username" required="">--%>
        <%--<div class="invalid-feedback" style="width: 100%;">--%>
        <%--Your username is required.--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>


        <div class="mb-3">
            <label for="hoursPerMonth">Hours/month</label>
            <form:input class="form-control" path="hoursPerMonth" id="hoursPerMonth"/>
            <form:errors path="hoursPerMonth" cssClass="error"/>
                <%--<input type="text" class="form-control" id="address" placeholder="1234 Main St" required="">--%>
                <%--<div class="invalid-feedback">--%>
                <%--Please enter your shipping address.--%>
                <%--</div>--%>
        </div>

        <div class="mb-3">
            <label for="address2">Address 2 <span class="text-muted">(Optional)</span></label>
            <input type="text" class="form-control" id="address2" placeholder="Apartment or suite">
        </div>

        <div class="row">
            <div class="col-md-5 mb-3">
                <label for="country">Country</label>
                <select class="custom-select d-block w-100" id="country" required="">
                    <option value="">Choose...</option>
                    <option>United States</option>
                </select>
                <div class="invalid-feedback">
                    Please select a valid country.
                </div>
            </div>
            <div class="col-md-4 mb-3">
                <label for="state">State</label>
                <select class="custom-select d-block w-100" id="state" required="">
                    <option value="">Choose...</option>
                    <option>California</option>
                </select>
                <div class="invalid-feedback">
                    Please provide a valid state.
                </div>
            </div>
            <div class="col-md-3 mb-3">
                <label for="zip">Zip</label>
                <input type="text" class="form-control" id="zip" placeholder="" required="">
                <div class="invalid-feedback">
                    Zip code required.
                </div>
            </div>
        </div>
        <table>
            <tr>
                <td><label for="personalNumber">Personal Number: </label></td>
                    <%--<td><form:input path="personalNumber" id="personalNumber"/></td>--%>
                <td><form:errors path="personalNumber" cssClass="error"/></td>
            </tr>

            <tr>
                <td><label for="firstName">First Name: </label></td>
                    <%--<td><form:input path="firstName" id="firstName"/></td>--%>
                <td><form:errors path="firstName" cssClass="error"/></td>
            </tr>

            <tr>
                <td><label for="lastName">Last Name: </label></td>
                    <%--<td><form:input path="lastName" id="lastName"/></td>--%>
                <td><form:errors path="lastName" cssClass="error"/></td>
            </tr>

            <tr>
                <td><label for="hoursPerMonth">Hours/month: </label></td>
                    <%--<td><form:input path="hoursPerMonth" id="hoursPerMonth"/></td>--%>
                <td><form:errors path="hoursPerMonth" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="currentCity">City: </label>
                <td>
                    <form:select path="currentCity" items="${cities}" itemLabel="name" itemValue="id"/>
                </td>
            </tr>
            <tr>
                <td colspan="3"><input type="submit" value="Register"/></td>
            </tr>
        </table>
    </form:form>
</t:wrapper>
