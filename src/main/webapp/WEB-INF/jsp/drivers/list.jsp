<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <div class="page-header mt-5">
        <h1>Welcome to the Drivers Page</h1>
    </div>
    <br/>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th scope="col">Personal Number</th>
            <th scope="col">Last Name</th>
            <th scope="col">First Name</th>
            <th/>
            <th/>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${drivers}" var="driver" varStatus="status">
            <tr>
                <th scope="row">${driver.personalNumber}</th>
                <td>${driver.lastName}</td>
                <td>${driver.firstName}</td>
                <td><a href="<c:url value='/drivers/delete/${driver.id}'/>">delete</a></td>
                <td><a href="<c:url value='/drivers/edit/${driver.id}'/>">edit</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a class="btn btn-primary" href="<c:url value='/drivers/create'/>" role="button">New Driver</a>
</t:wrapper>
