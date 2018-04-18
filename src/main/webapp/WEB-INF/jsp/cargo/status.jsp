<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <div class="page-header mt-5">
        <h1></h1>
    </div>
    <br/>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th scope="col">Number</th>
            <th scope="col">Status</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cargo}" var="cargo" varStatus="status">
            <tr>
                <th scope="row">${cargo.number}</th>
                <td>${cargo.cargoStatus}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</t:wrapper>