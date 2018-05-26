<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>--%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>

<%--<t:wrapper>--%>

    <%--<div class="container">--%>
        <%--<div class="py-5 text-left">--%>
            <%--<h2>New Order Form</h2>--%>
        <%--</div>--%>

        <%--<div class="row">--%>
            <%--<div class="col-md-8 order-md-1">--%>
                <%--<h4 class="mb-1">Step 1</h4>--%>
                <%--<hr class="mb-4">--%>
                <%--<form:form action="/orders/create/waypoint" method="GET" modelAttribute="order">--%>
                    <%--<div class="row">--%>
                        <%--<div class="col-md-6 mb-3">--%>
                            <%--<label for="uniqueNumber">Order's unique number: </label>--%>
                            <%--<form:input path="uniqueNumber" id="uniqueNumber"/>--%>
                            <%--<p class="text-danger">--%>
                                <%--<form:errors class="text-danger" path="uniqueNumber" cssClass="error"/>--%>
                            <%--</p>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<hr class="mb-4">--%>
                    <%--<a class="btn btn-secondary" href="/orders/list" role="button">Back to Order's List</a>--%>
                    <%--<button class="btn btn-primary" type="submit">Next Step</button>--%>
                <%--</form:form>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>

<%--</t:wrapper>--%>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <title>Waypoints in directions</title>
    <style>
        #right-panel {
            font-family: 'Roboto','sans-serif';
            line-height: 30px;
            padding-left: 10px;
        }

        #right-panel select, #right-panel input {
            font-size: 15px;
        }

        #right-panel select {
            width: 100%;
        }

        #right-panel i {
            font-size: 12px;
        }
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
        }
        #map {
            height: 100%;
            float: left;
            width: 70%;
            height: 100%;
        }
        #right-panel {
            margin: 20px;
            border-width: 2px;
            width: 20%;
            height: 400px;
            float: left;
            text-align: left;
            padding-top: 0;
        }
        #directions-panel {
            margin-top: 10px;
            background-color: #FFEE77;
            padding: 10px;
            overflow: scroll;
            height: 174px;
        }
    </style>
</head>
<body>
<div id="map"></div>
<div id="right-panel">
    <div>
        <b>Start:</b>
        <select id="start">
            <option value="Halifax, NS">Halifax, NS</option>
            <option value="Boston, MA">Boston, MA</option>
            <option value="New York, NY">New York, NY</option>
            <option value="Miami, FL">Miami, FL</option>
        </select>
        <br>
        <b>Waypoints:</b> <br>
        <i>(Ctrl+Click or Cmd+Click for multiple selection)</i> <br>
        <select multiple id="waypoints">
            <option value="montreal, quebec">Montreal, QBC</option>
            <option value="toronto, ont">Toronto, ONT</option>
            <option value="chicago, il">Chicago</option>
            <option value="winnipeg, mb">Winnipeg</option>
            <option value="fargo, nd">Fargo</option>
            <option value="calgary, ab">Calgary</option>
            <option value="spokane, wa">Spokane</option>
        </select>
        <br>
        <b>End:</b>
        <select id="end">
            <option value="Vancouver, BC">Vancouver, BC</option>
            <option value="Seattle, WA">Seattle, WA</option>
            <option value="San Francisco, CA">San Francisco, CA</option>
            <option value="Los Angeles, CA">Los Angeles, CA</option>
        </select>
        <br>
        <input type="submit" id="submit">
    </div>
    <div id="directions-panel"></div>
</div>
<script>
    function initMap() {
        var directionsService = new google.maps.DirectionsService;
        var directionsDisplay = new google.maps.DirectionsRenderer;
        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 6,
            center: {lat: 41.85, lng: -87.65}
        });
        directionsDisplay.setMap(map);

        document.getElementById('submit').addEventListener('click', function() {
            calculateAndDisplayRoute(directionsService, directionsDisplay);
        });
    }

    function calculateAndDisplayRoute(directionsService, directionsDisplay) {
        var waypts = [];
        var checkboxArray = document.getElementById('waypoints');
        for (var i = 0; i < checkboxArray.length; i++) {
            if (checkboxArray.options[i].selected) {
                waypts.push({
                    location: checkboxArray[i].value,
                    stopover: true
                });
            }
        }

        directionsService.route({
            origin: document.getElementById('start').value,
            destination: document.getElementById('end').value,
            waypoints: waypts,
            optimizeWaypoints: true,
            travelMode: 'DRIVING'
        }, function(response, status) {
            if (status === 'OK') {
                 directionsDisplay.setDirections(response);
                // var route = response.routes[0];
                // var summaryPanel = document.getElementById('directions-panel');
                // summaryPanel.innerHTML = '';
                // For each route, display summary information.
                // for (var i = 0; i < route.legs.length; i++) {
                //     var routeSegment = i + 1;
                //     summaryPanel.innerHTML += '<b>Route Segment: ' + routeSegment +
                //         '</b><br>';
                //     summaryPanel.innerHTML += route.legs[i].start_address + ' to ';
                //     summaryPanel.innerHTML += route.legs[i].end_address + '<br>';
                //     summaryPanel.innerHTML += route.legs[i].distance.text + '<br><br>';
                // }
            } else {
                window.alert('Directions request failed due to ' + status);
            }
        });
    }
</script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAVIHJyzMB3OZ9HPs8oQJHGHorJboK2zog&callback=initMap">
</script>
</body>
</html>

<%--<div>--%>
<%--<div class="span-4">--%>
<%--<label for="orderTime">Check In:</label>--%>
<%--</div>--%>
<%--<div class="last">--%>
<%--<p><form:input path="orderTime"/></p>--%>
<%--<script type="text/javascript">--%>
<%--Spring.addDecoration(new Spring.ElementDecoration({--%>
<%--elementId: "orderTime",--%>
<%--widgetType: "dijit.form.DateTextBox",--%>
<%--widgetAttrs: {datePattern: "MM-dd-yyyy", required: true}--%>
<%--}));--%>
<%--</script>--%>

<%--</div>--%>
<%--</div>--%>