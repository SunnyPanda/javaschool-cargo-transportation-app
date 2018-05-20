<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:wrapper>
    <div class="page-header">
        <h1></h1>
    </div>
    <%--<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">--%>

    <%--<canvas class="my-4 w-100 chartjs-render-monitor" id="myChart" width="2073" height="875" style="display: block; width: 2073px; height: 875px;"></canvas>--%>


    <%--</main>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</br>--%>

    <form:form action="orders/search" method="POST" modelAttribute="order">
        <label for="uniqueNumber">Узнать статус заказа:</label>
        <input type="number" path="uniqueNumber" id="uniqueNumber" name="uniqueNumber"
               placeholder="Введите номер заказа"/>
        <input type="submit" value="Search"/>
    </form:form>
    </br>
    </br>
    <form:form action="cargo/search" method="POST" modelAttribute="cargo">
        <label for="number">Узнать статус груза:</label>
        <input type="number" path="number" id="number" name="number" placeholder="Введите номер груза"/>
        <input type="submit" value="Search"/>
    </form:form>

    <a href="<c:url value='/cargo/status' />">Cargo's status</a>
    <br/>
    <a href="<c:url value='/orders/status' />">Order's status</a>

</t:wrapper>

