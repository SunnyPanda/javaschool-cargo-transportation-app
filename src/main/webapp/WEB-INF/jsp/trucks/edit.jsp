<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <div class="container">
        <div class="py-5 text-left">
            <h2>Edit Truck</h2>
        </div>
        <form:form method="POST" modelAttribute="truck">
        <div class="col-md-8 order-md-1">
            <div class="mb-3">
                <label for="regNumber">Registration number</label>
                <form:input class="form-control" path="regNumber" id="regNumber"/>
                <p class="text-danger">
                    <form:errors path="regNumber" cssClass="error"/>
                </p>

            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="shiftSize">Shift size</label>
                    <form:input class="form-control" path="shiftSize" id="shiftSize"/>
                    <p class="text-danger">
                        <form:errors path="shiftSize" cssClass="error"/>
                    </p>

                </div>
                <div class="col-md-6 mb-3">
                    <label for="capacity">Capacity</label>
                    <form:input class="form-control" path="capacity" id="capacity"/>
                    <p class="text-danger">
                        <form:errors path="capacity" cssClass="error"/>
                    </p>

                </div>
            </div>

            <div class="mb-3">
                <label for="truckState">Truck state</label>
                <form:select class="custom-select d-block w-100" path="truckState" items="${stateValues}" itemLabel="label" itemValue="name" />
            </div>

            <div class="mb-3">
                <label for="currentCity">City</label>
                <form:select class="custom-select d-block w-100" path="currentCity" items="${cities}" itemLabel="name" itemValue="id"/>
            </div>
            <hr class="mb-4">
            <a class="btn btn-secondary" href="/manager/trucks/list" role="button">Back</a>
            <button class="btn btn-primary" type="submit">Create</button>
            </form:form>
        </div>
    </div>
</t:wrapper>