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
                <hr class="mb-4">
                <form:form action="/manager/orders/savetruck" method="POST" modelAttribute="order">
                    <div class="row">
                        <div class="col-md-6 mb-3">
                                <label for="truck">Choose truck: </label>
                                <form:select class="custom-select d-block w-100" path="truck" items="${trucks}" itemValue="id" itemLabel="regNumber"/>
                            <p class="text-danger">
                                <form:errors class="text-danger" path="truck" cssClass="error"/>
                            </p>
                            <div class="mb-4">
                                <button class="btn btn-success" type="submit">Add truck</button>
                            </div>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label>Your choice: ${order.truck.regNumber} </label>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>

    </div>


    <form:form action="/manager/orders/adddriver" method="GET" modelAttribute="order">
        <hr class="mb-4">
        <a class="btn btn-secondary" href="/manager/orders/create/waypoint" role="button">Previous Step</a>
        <button class="btn btn-primary" type="submit">Next Step</button>
    </form:form>
</t:wrapper>
