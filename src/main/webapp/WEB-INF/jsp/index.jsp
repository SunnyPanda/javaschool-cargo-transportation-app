<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:wrapper>
    <div class="page-header">
        <h1></h1>
    </div>
    </br>
    <form:form action="orders/search" method="POST" modelAttribute="order">
        <label for="uniqueNumber">Узнать статус заказа:</label>
        <input type="number" path="uniqueNumber" id="uniqueNumber" name="uniqueNumber"
               placeholder="Введите номер заказа"/>
        <input type="submit" value="Search"/>
    </form:form>
    </br>
    </br>
    <form:form action="cargo/search" method="POST" modelAttribute="cargo">
        <label for="number">Узнать статус груза:</label>
        <input type="number" path="number" id="number" name="number" placeholder="Введите номер груза"/>
        <input type="submit" value="Search"/>
    </form:form>
    <a href="<c:url value='/drivers/list' />">Drivers List</a>
    <br/>
    <a href="<c:url value='/trucks/list' />">Trucks List</a>
    <br/>
    <a href="<c:url value='/cities/list' />">Cities List</a>
    <br/>
    <a href="<c:url value='/cargo/list' />">Cargo List</a>
    <br/>
    <a href="<c:url value='/waypoints/list' />">Waypoints List</a>
    <br/>
    <a href="<c:url value='/orders/list' />">Orders List</a>
    <br/>
    <br/>
    <br/>
    <a href="<c:url value='/cargo/status' />">Cargo's status</a>
    <br/>
    <a href="<c:url value='/orders/status' />">Order's status</a>
</t:wrapper>