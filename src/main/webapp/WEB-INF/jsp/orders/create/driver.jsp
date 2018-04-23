<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    </br>
    <div class="page-header">
        <h2>Drivers</h2>
    </div>
    <form:form action="/orders/savedriver" method="POST" modelAttribute="order">
        <c:forEach items="${order.drivers}" var="driver" varStatus="status">
            <tr>
                <td>${driver.personalNumber}</td>
            </tr>
        </c:forEach>
        <table>
            <td><label for="drivers">Выберите ${order.truck.shiftSize}х водителей:</label></td>
            <td>
                <ul>
                    <form:select path="drivers" items="${drivers}" itemValue="id" itemLabel="personalNumber"
                                 multiple="true"/>
                </ul>
            </td>
            <td colspan="3"><input type="submit" value="Выбрать"/></td>
        </table>
    </form:form>

    <form:form action="/orders/list" method="GET" modelAttribute="order">
        <td colspan="3"><input type="submit" value="Finish"/></td>
    </form:form>
</t:wrapper>