<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <div class="page-header mt-5">
        <h1>Welcome to the Cities Page</h1>
    </div>
    <br/>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th scope="col">City Name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cities}" var="city" varStatus="status">
            <tr>
                <td>${city.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</t:wrapper>