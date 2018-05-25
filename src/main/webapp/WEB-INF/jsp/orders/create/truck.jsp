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
                <h4 class="mb-1">Step 3</h4>
                <form:form action="/orders/savetruck" method="POST" modelAttribute="order">
                    <td>${order.truck.regNumber}</td>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="truck">Choose truck: </label>
                            <form:select path="truck" items="${trucks}" itemValue="id" itemLabel="regNumber"/>
                        </div>
                    </div>
                    <div class="mb-4">
                        <button class="btn btn-secondary" type="submit">Add truck</button>
                    </div>
                    <%--<div class="col-md-6 mb-3">--%>
                    <%--<label for="output">Your truck: </label>--%>
                    <%--&lt;%&ndash;<form:&ndash;%&gt;--%>
                    <%--<output path="truck" id="output" />--%>
                    <%--</div>--%>

                </form:form>
            </div>
        </div>

    </div>


    <form:form action="/orders/adddriver" method="GET" modelAttribute="order">
        <hr class="mb-4">
        <a class="btn btn-primary" href="/orders/create/waypoint" role="button">Previous Step</a>
        <button class="btn btn-primary" type="submit">Next Step</button>
    </form:form>
</t:wrapper>
<%--</br>--%>
<%--<div class="page-header">--%>
<%--<h2>Truck</h2>--%>
<%--</div>--%>
<%--<form:form action="/orders/savetruck" method="POST" modelAttribute="order">--%>
<%--<td>${order.truck.regNumber}</td>--%>
<%--<table>--%>
<%--<td><label for="truck">Выберите фуру:</label></td>--%>
<%--<td>--%>
<%--<form:select path="truck" items="${trucks}" itemValue="id" itemLabel="regNumber" multiple="true"/>--%>
<%--</td>--%>
<%--<td colspan="3"><input type="submit" value="Выбрать"/></td>--%>
<%--</table>--%>
<%--</form:form>--%>