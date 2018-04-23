<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    </br>
    <div class="page-header">
        <h2>New Driver</h2>
    </div>
    <form:form method="POST" modelAttribute="driver">
        <table>
            <tr>
                <td><label for="personalNumber">Personal Number: </label></td>
                <td><form:input path="personalNumber" id="personalNumber"/></td>
                <td><form:errors path="personalNumber" cssClass="error"/></td>
            </tr>

            <tr>
                <td><label for="firstName">First Name: </label></td>
                <td><form:input path="firstName" id="firstName"/></td>
                <td><form:errors path="firstName" cssClass="error"/></td>
            </tr>

            <tr>
                <td><label for="lastName">Last Name: </label></td>
                <td><form:input path="lastName" id="lastName"/></td>
                <td><form:errors path="lastName" cssClass="error"/></td>
            </tr>

            <tr>
                <td><label for="hoursPerMonth">Hours/month: </label></td>
                <td><form:input path="hoursPerMonth" id="hoursPerMonth"/></td>
                <td><form:errors path="hoursPerMonth" cssClass="error"/></td>
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
