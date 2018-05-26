<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<t:wrapper>

    <div class="container">
        <div class="py-5 text-left">
            <h2>New Order Form</h2>
        </div>

        <div class="row">
            <div class="col-md-8 order-md-1">
                <h4 class="mb-1">Step 1</h4>
                <form:form action="/orders/create/waypoint" method="GET" modelAttribute="order">
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="uniqueNumber">Order's unique number: </label>
                            <form:input path="uniqueNumber" id="uniqueNumber"/>
                            <p class="text-danger">
                                <form:errors class="text-danger" path="uniqueNumber" cssClass="error"/>
                            </p>
                        </div>
                    </div>
                    <hr class="mb-4">
                    <a class="btn btn-primary" href="/orders/list" role="button">Back to Order's List</a>
                    <button class="btn btn-primary" type="submit">Next Step</button>
                </form:form>
            </div>
        </div>
    </div>

</t:wrapper>

<%--<div>--%>
<%--<div class="span-4">--%>
<%--<label for="orderTime">Check In:</label>--%>
<%--</div>--%>
<%--<div class="last">--%>
<%--<p><form:input path="orderTime"/></p>--%>
<%--<script type="text/javascript">--%>
<%--Spring.addDecoration(new Spring.ElementDecoration({--%>
<%--elementId: "orderTime",--%>
<%--widgetType: "dijit.form.DateTextBox",--%>
<%--widgetAttrs: {datePattern: "MM-dd-yyyy", required: true}--%>
<%--}));--%>
<%--</script>--%>

<%--</div>--%>
<%--</div>--%>