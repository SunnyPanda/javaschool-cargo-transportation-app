<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <div class="page-header mt-5">
        <h1>Welcome to the Cargo Page</h1>
    </div>
    <br/>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th scope="col">Number</th>
            <th scope="col">Name</th>
            <th scope="col">Weight</th>
            <th scope="col">Status</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cargo}" var="cargo" varStatus="status">
            <tr>
                <th scope="row">${cargo.number}</th>
                <td>${cargo.name}</td>
                <td>${cargo.weight}</td>
                <td>${cargo.cargoStatus}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</t:wrapper>
