<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:simplewrapper>
    <c:url value="/login" var="loginUrl"/>
    <form:form name="f" action="${loginUrl}" method="post">
        <fieldset>
            <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
            <c:if test="${param.error != null}">
                <div class="alert alert-error">
                    Invalid username and password.
                </div>
            </c:if>
            <c:if test="${param.logout != null}">
                <div class="alert alert-success">
                    You have been logged out.
                </div>
            </c:if>
            <label for="username">Username</label>
            <input class="form-control" id="username" name="username" value="${username}"/>
            <label for="password">Password</label>
            <input class="form-control" type="password" id="password" name="password"/>

            <div class="form-actions">
                <%--<button type="submit" class="btn">Log in</button>--%>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            </div>
        </fieldset>
    </form:form>
</t:simplewrapper>
