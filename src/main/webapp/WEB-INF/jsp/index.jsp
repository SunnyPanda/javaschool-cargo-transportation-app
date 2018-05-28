<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:wrapper>
    <div class="container">
        <div class="row">
            <div class="col-md-6 mb-3">
                <form:form action="orders/search" method="POST" modelAttribute="order">
                    <label for="uniqueNumber">Searching for order status</label>
                    <input class="form-control" type="number" path="uniqueNumber" id="uniqueNumber" name="uniqueNumber"
                           placeholder="Enter the order unique number"/>
                    <button class="btn btn-primary" type="submit">Search</button>
                </form:form>
            </div>
            <div class="col-md-6 mb-3">
                <form:form action="cargo/search" method="POST" modelAttribute="cargo">
                    <label for="number">Searching for cargo status</label>
                    <input class="form-control" type="number" path="number" id="number" name="number" placeholder="Enter the cargo number"/>
                    <button class="btn btn-primary" type="submit">Search</button>
                </form:form>
            </div>
        </div>
        <form:form action="/orders/create/number" method="GET">
            <button class="btn btn-primary" type="submit">New Order</button>
        </form:form>

    </div>


    <%--<label for="personalNumber">Personal number</label>--%>
    <%--<form:input class="form-control" path="personalNumber" id="personalNumber"/>--%>

</t:wrapper>

