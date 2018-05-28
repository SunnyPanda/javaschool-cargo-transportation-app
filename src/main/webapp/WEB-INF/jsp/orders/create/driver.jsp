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
                <h4 class="mb-1">Step 4</h4>
                <hr class="mb-4">
                <form:form action="/orders/savedriver" method="POST" modelAttribute="order">
                    <%--<td>#{order.truck.regNumber}</td>--%>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="drivers">Choose drivers: </label>
                            <form:select class="custom-select d-block w-100" path="drivers" items="${drivers}" itemValue="id" itemLabel="personalNumber"
                                         multiple="true"/>
                        </div>
                    </div>
                    <div class="mb-4">
                        <button class="btn btn-success" type="submit">Add drivers</button>
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


    <form:form action="/orders/create/number" method="GET" modelAttribute="order">
        <hr class="mb-4">
        <a class="btn btn-secondary" href="/orders/addtruck" role="button">Previous Step</a>
        <button class="btn btn-primary" type="submit">Next</button>
    </form:form>
    <%--</br>--%>
    <%--<div class="page-header">--%>
    <%--<h2>Drivers</h2>--%>
    <%--</div>--%>
    <%--<form:form action="/orders/savedriver" method="POST" modelAttribute="order">--%>
    <%--<c:forEach items="${order.drivers}" var="driver" varStatus="status">--%>
    <%--<tr>--%>
    <%--<td>${driver.personalNumber}</td>--%>
    <%--</tr>--%>
    <%--</c:forEach>--%>
    <%--<table>--%>
    <%--<td><label for="drivers">Выберите ${order.truck.shiftSize}х водителей:</label></td>--%>
    <%--<td>--%>
    <%--<ul>--%>
    <%--<form:select path="drivers" items="${drivers}" itemValue="id" itemLabel="personalNumber"--%>
    <%--multiple="true"/>--%>
    <%--</ul>--%>
    <%--</td>--%>
    <%--<td colspan="3"><input type="submit" value="Выбрать"/></td>--%>
    <%--</table>--%>
    <%--</form:form>--%>

    <%--<form:form action="/orders/save" method="GET" modelAttribute="order">--%>
    <%--<td colspan="3"><input type="submit" value="Finish"/></td>--%>
    <%--</form:form>--%>
</t:wrapper>