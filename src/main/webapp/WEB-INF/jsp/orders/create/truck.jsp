<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    </br>
    <div class="page-header">
        <h2>Truck</h2>
    </div>
    <form:form action="/orders/savetruck" method="POST" modelAttribute="order">
        <td>${order.truck.regNumber}</td>
        <table>
            <td><label for="truck">Выберите фуру:</label></td>
            <td>
                <form:select path="truck" id="truck" multiple="true">
                    <form:options items="${trucks}"/>
                </form:select>
            </td>
            <td colspan="3"><input type="submit" value="Выбрать"/></td>
        </table>
    </form:form>

    <form:form action="/orders/adddriver" method="POST" modelAttribute="order">
        <td colspan="3"><input type="submit" value="Next"/></td>
    </form:form>
</t:wrapper>
