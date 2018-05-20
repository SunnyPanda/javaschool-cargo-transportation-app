<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <div class="page-header mt-5">
        <h1>Welcome to the Drivers Page</h1>
    </div>

    <%--<div id="table-normal_wrapper" class="dataTables_wrapper container-fluid dt-bootstrap4">--%>
    <%--<div class="row">--%>
    <%--<div class="col-sm-12 col-md-6">--%>
    <%--<div class="dataTables_length" id="table-normal_length">--%>
    <%--&lt;%&ndash;<label>Show <select name="table-normal_length" aria-controls="table-normal" class="form-control form-control-sm">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<option value="10">10</option>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<option value="25">25</option>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<option value="50">50</option>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<option value="100">100</option>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</select> entries</label>&ndash;%&gt;--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--<div class="col-sm-12 col-md-6">--%>
    <%--<div id="table-normal_filter" class="dataTables_filter">--%>
    <%--<label>Search:--%>
    <%--<input type="search" class="form-control form-control-sm" placeholder="" aria-controls="table-normal">--%>
    <%--</label>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--<div class="row">--%>
    <%--<div class="col-sm-12">--%>
    <%--<table id="table-normal" class="table table-striped table-bordered dataTable" cellspacing="0" width="100%" role="grid" aria-describedby="table-normal_info" style="width: 100%;">--%>
    <%--<thead>--%>
    <%--<tr role="row">--%>
    <%--<th class="sorting_asc" tabindex="0" aria-controls="table-normal" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 177px;">Name</th>--%>
    <%--<th class="sorting" tabindex="0" aria-controls="table-normal" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending" style="width: 282px;">Position</th>--%>
    <%--<th class="sorting" tabindex="0" aria-controls="table-normal" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending" style="width: 126px;">Office</th>--%>
    <%--<th class="sorting" tabindex="0" aria-controls="table-normal" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending" style="width: 57px;">Age</th>--%>
    <%--<th class="sorting" tabindex="0" aria-controls="table-normal" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending" style="width: 118px;">Start date</th>--%>
    <%--<th class="sorting" tabindex="0" aria-controls="table-normal" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending" style="width: 100px;">Salary</th>--%>
    <%--</tr>--%>
    <%--</thead>--%>
    <%--<tfoot>--%>
    <%--<tr>--%>
    <%--<th rowspan="1" colspan="1">Name</th>--%>
    <%--<th rowspan="1" colspan="1">Position</th>--%>
    <%--<th rowspan="1" colspan="1">Office</th>--%>
    <%--<th rowspan="1" colspan="1">Age</th>--%>
    <%--<th rowspan="1" colspan="1">Start date</th>--%>
    <%--<th rowspan="1" colspan="1">Salary</th>--%>
    <%--</tr>--%>
    <%--</tfoot>--%>
    <%--<tbody>--%>
    <%--<tr role="row" class="odd">--%>
    <%--<td class="sorting_1">Airi Satou</td>--%>
    <%--<td>Accountant</td>--%>
    <%--<td>Tokyo</td>--%>
    <%--<td>33</td>--%>
    <%--<td>2008/11/28</td>--%>
    <%--<td>$162,700</td>--%>
    <%--</tr><tr role="row" class="even">--%>
    <%--<td class="sorting_1">Angelica Ramos</td>--%>
    <%--<td>Chief Executive Officer (CEO)</td>--%>
    <%--<td>London</td>--%>
    <%--<td>47</td>--%>
    <%--<td>2009/10/09</td>--%>
    <%--<td>$1,200,000</td>--%>
    <%--</tr><tr role="row" class="odd">--%>
    <%--<td class="sorting_1">Ashton Cox</td>--%>
    <%--<td>Junior Technical Author</td>--%>
    <%--<td>San Francisco</td>--%>
    <%--<td>66</td>--%>
    <%--<td>2009/01/12</td>--%>
    <%--<td>$86,000</td>--%>
    <%--</tr><tr role="row" class="even">--%>
    <%--<td class="sorting_1">Bradley Greer</td>--%>
    <%--<td>Software Engineer</td>--%>
    <%--<td>London</td>--%>
    <%--<td>41</td>--%>
    <%--<td>2012/10/13</td>--%>
    <%--<td>$132,000</td>--%>
    <%--</tr><tr role="row" class="odd">--%>
    <%--<td class="sorting_1">Brenden Wagner</td>--%>
    <%--<td>Software Engineer</td>--%>
    <%--<td>San Francisco</td>--%>
    <%--<td>28</td>--%>
    <%--<td>2011/06/07</td>--%>
    <%--<td>$206,850</td>--%>
    <%--</tr><tr role="row" class="even">--%>
    <%--<td class="sorting_1">Brielle Williamson</td>--%>
    <%--<td>Integration Specialist</td>--%>
    <%--<td>New York</td>--%>
    <%--<td>61</td>--%>
    <%--<td>2012/12/02</td>--%>
    <%--<td>$372,000</td>--%>
    <%--</tr><tr role="row" class="odd">--%>
    <%--<td class="sorting_1">Bruno Nash</td>--%>
    <%--<td>Software Engineer</td>--%>
    <%--<td>London</td>--%>
    <%--<td>38</td>--%>
    <%--<td>2011/05/03</td>--%>
    <%--<td>$163,500</td>--%>
    <%--</tr><tr role="row" class="even">--%>
    <%--<td class="sorting_1">Caesar Vance</td>--%>
    <%--<td>Pre-Sales Support</td>--%>
    <%--<td>New York</td>--%>
    <%--<td>21</td>--%>
    <%--<td>2011/12/12</td>--%>
    <%--<td>$106,450</td>--%>
    <%--</tr><tr role="row" class="odd">--%>
    <%--<td class="sorting_1">Cara Stevens</td>--%>
    <%--<td>Sales Assistant</td>--%>
    <%--<td>New York</td>--%>
    <%--<td>46</td>--%>
    <%--<td>2011/12/06</td>--%>
    <%--<td>$145,600</td>--%>
    <%--</tr><tr role="row" class="even">--%>
    <%--<td class="sorting_1">Cedric Kelly</td>--%>
    <%--<td>Senior Javascript Developer</td>--%>
    <%--<td>Edinburgh</td>--%>
    <%--<td>22</td>--%>
    <%--<td>2012/03/29</td>--%>
    <%--<td>$433,060</td>--%>
    <%--</tr>--%>
    <%--</tbody>--%>
    <%--</table>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--<div class="row">--%>
    <%--<div class="col-sm-12 col-md-5">--%>
    <%--<div class="dataTables_info" id="table-normal_info" role="status" aria-live="polite">Showing 1 to 10 of 57 entries</div>--%>
    <%--</div>--%>
    <%--<div class="col-sm-12 col-md-7">--%>
    <%--<div class="dataTables_paginate paging_simple_numbers" id="table-normal_paginate">--%>
    <%--<ul class="pagination">--%>
    <%--<li class="paginate_button page-item previous disabled" id="table-normal_previous">--%>
    <%--<a href="#" aria-controls="table-normal" data-dt-idx="0" tabindex="0" class="page-link">Previous</a>--%>
    <%--</li>--%>
    <%--<li class="paginate_button page-item active">--%>
    <%--<a href="#" aria-controls="table-normal" data-dt-idx="1" tabindex="0" class="page-link">1</a>--%>
    <%--</li>--%>
    <%--<li class="paginate_button page-item ">--%>
    <%--<a href="#" aria-controls="table-normal" data-dt-idx="2" tabindex="0" class="page-link">2</a>--%>
    <%--</li>--%>
    <%--<li class="paginate_button page-item ">--%>
    <%--<a href="#" aria-controls="table-normal" data-dt-idx="3" tabindex="0" class="page-link">3</a>--%>
    <%--</li>--%>
    <%--<li class="paginate_button page-item ">--%>
    <%--<a href="#" aria-controls="table-normal" data-dt-idx="4" tabindex="0" class="page-link">4</a>--%>
    <%--</li>--%>
    <%--<li class="paginate_button page-item ">--%>
    <%--<a href="#" aria-controls="table-normal" data-dt-idx="5" tabindex="0" class="page-link">5</a>--%>
    <%--</li>--%>
    <%--<li class="paginate_button page-item ">--%>
    <%--<a href="#" aria-controls="table-normal" data-dt-idx="6" tabindex="0" class="page-link">6</a>--%>
    <%--</li>--%>
    <%--<li class="paginate_button page-item next" id="table-normal_next">--%>
    <%--<a href="#" aria-controls="table-normal" data-dt-idx="7" tabindex="0" class="page-link">Next</a>--%>
    <%--</li>--%>
    <%--</ul>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <a class="btn btn-primary" href="<c:url value='/drivers/create'/>" role="button">New Driver</a>
    <br/>
    <%--<div class="input-group has-clearable">--%>
    <%--<button id="clear-search" type="button" class="close" aria-label="Close">--%>
    <%--<span aria-hidden="true">--%>
    <%--<i class="fa fa-times-circle"></i>--%>
    <%--</span>--%>
    <%--</button>--%>
    <%--<div class="input-group-prepend">--%>
    <%--<span class="input-group-text">--%>
    <%--<span class="oi oi-magnifying-glass"></span>--%>
    <%--</span>--%>
    <%--</div>--%>
    <%--<input id="table-search" type="text" class="form-control placeholder-shown" placeholder="Search products">--%>
    <%--</div>--%>

    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th scope="col">Personal Number</th>
            <th scope="col">Last Name</th>
            <th scope="col">First Name</th>
            <th scope="col">Hours/month</th>
            <th scope="col">Status</th>
            <th scope="col">City</th>
            <th scope="col">Truck</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${drivers}" var="driver" varStatus="status">
            <tr>
                <th scope="row">${driver.personalNumber}</th>
                <td>${driver.firstName}</td>
                <td>${driver.lastName}</td>
                <td>${driver.hoursPerMonth}</td>
                <td>${driver.driverStatus.toString()}</td>
                <td>${driver.currentCity.name}</td>
                <td>${driver.currentTruck.regNumber}</td>
                <td><a href="<c:url value='/drivers/edit/${driver.id}'/>">edit</a></td>
                <td><a href="<c:url value='/drivers/delete/${driver.id}'/>">delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</t:wrapper>
