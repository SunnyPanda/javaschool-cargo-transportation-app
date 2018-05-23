<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <form:form method="POST" modelAttribute="waypoint">
        <table>
            <tr>
                <td><label for="city">City: </label>
                <td>
                    <form:select path="city" items="${cities}" itemLabel="name" itemValue="id"/>
                </td>
            </tr>

            <tr>
                <td><label for="cargo">Cargo: </label>
                <td>
                    <form:select path="cargo" items="${cargo}" itemLabel="name" itemValue="id"/>
                </td>
            </tr>

            <tr>
                <td><label for="waypointType">Type: </label></td>
                <td>
                    <form:select path="waypointType" items="${waypointType}" itemLabel="label" itemValue="name"/>
                </td>
                <td><form:errors path="waypointType" cssClass="error"/></td>
            </tr>

            <tr>
                <td colspan="3"><input type="submit" value="Add Waypoint"/></td>
            </tr>
        </table>

    </form:form>
</t:wrapper>

