<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <h1>Welcome Page</h1>
    <a href="<c:url value='/drivers/list' />">Drivers List</a>
    <br/>
    <a href="<c:url value='/trucks/list' />">Trucks List</a>
    <br/>
    <a href="<c:url value='/cities/list' />">Cities List</a>
    <br/>
    <a href="<c:url value='/cargo/list' />">Cargo List</a>
    <br/>
    <a href="<c:url value='/waypoints/list' />">Waypoints List</a>
</t:wrapper>