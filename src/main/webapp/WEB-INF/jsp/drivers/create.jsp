<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <div class="container">
        <div class="py-5 text-left">
                <h2>New Driver</h2>
        </div>
        <form:form method="POST" modelAttribute="driver">
            <div class="col-md-8 order-md-1">
            <div class="mb-3">
                <label for="personalNumber">Unique number</label>
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

            <div class="mb-3">
                <label for="currentCity">City</label>
                <form:select class="custom-select d-block w-100" path="currentCity" items="${cities}" itemLabel="name" itemValue="id"/>
            </div>
            <hr class="mb-4">
            <a class="btn btn-secondary" href="/drivers/list" role="button">Back</a>
            <button class="btn btn-primary" type="submit">Create</button>
        </form:form>
    </div>
</t:wrapper>
