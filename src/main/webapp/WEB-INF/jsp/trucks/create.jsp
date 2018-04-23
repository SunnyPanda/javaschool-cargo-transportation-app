<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    </br>
    <div class="page-header">
        <h2>New Truck</h2>
    </div>
    <form:form method="POST" modelAttribute="truck">
        <table>
            <tr>
                <td><label for="regNumber">Регистрационный номер: </label></td>
                <td><form:input path="regNumber" id="regNumber"/></td>
                <td>
                        <form:errors path="regNumber" cssClass="error"/>
                        <%--<span id="regNumber" class="error">Error!<span>/td>--%>

            </tr>

            <tr>
                <td><label for="shiftSize">Размер смены: </label></td>
                <td><form:input path="shiftSize" id="shiftSize"/></td>
                <td><form:errors path="shiftSize" cssClass="error"/></td>
            </tr>

            <tr>
                <td><label for="capacity">Вместимость: </label></td>
                <td><form:input path="capacity" id="capacity"/></td>
                <td><form:errors path="capacity" cssClass="error"/></td>
            </tr>

            <tr>
                <td><label for="truckState">Состояние: </label></td>
                <td>
                    <form:select path="truckState" items="${stateValues}" itemLabel="label" itemValue="name"/>
                </td>
                <td><form:errors path="truckState" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="currentCity">City: </label>
                <td>
                    <form:select path="currentCity" items="${cities}" itemLabel="name" itemValue="id"/>
                </td>
            </tr>

            <tr>
                <td colspan="3"><input type="submit" value="Register"/></td>
            </tr>
        </table>
    </form:form>
</t:wrapper>