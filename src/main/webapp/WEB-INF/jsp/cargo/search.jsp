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
            <th scope="col">Status</th>
        </tr>
        </thead>
        <tbody>
        <th scope="row">${cargo.cargoStatus}</th>
        </tbody>
    </table>
</t:wrapper>
