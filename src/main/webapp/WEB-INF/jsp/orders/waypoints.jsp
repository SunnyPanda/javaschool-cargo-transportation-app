<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <div class="container">
        <div class="py-5 text-left">
            <h2>Waypoints</h2>
            <hr class="mb-4">
        </div>
        <a class="btn btn-primary" href="/orders/list" role="button">Back</a>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th scope="col">City</th>
            <th scope="col">Cargo</th>
            <th scope="col">Type</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${waypoints}" var="waypoint" varStatus="status">
            <tr>
                <td>${waypoint.city.name}</td>
                <td>${waypoint.cargo.name}</td>
                <td>${waypoint.waypointType.toString()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


    <div id="map"></div>
    </div>
    <script>
        function initMap() {
            console.log("initMap");
            // var uluru = {lat: -25.363, lng: 131.044};
            // var map = new google.maps.Map(document.getElementById('map'), {
            //     zoom: 4,
            //     center: uluru
            // });
            var directionsService = new google.maps.DirectionsService;
            var directionsDisplay = new google.maps.DirectionsRenderer;
            var map = new google.maps.Map(document.getElementById('map'), {
                zoom: 6,
                center: {lat: 55.804, lng: 37.789}
            });

            directionsDisplay.setMap(map);

            $.getJSON("/api/waypoints/${order.id}", function (data) {
                calculateAndDisplayRoute(directionsService, directionsDisplay, data);
            });
        }

        function calculateAndDisplayRoute(directionsService, directionsDisplay, routePoints) {
            var destination = routePoints.pop();
            var origin = routePoints.shift();
            var waypoints = routePoints.map(function (waypointName) {
                return {location: waypointName}
            });

            console.log("origin:", origin);
            console.log("destination:", destination);
            console.log("waypoints:", waypoints);

            directionsService.route({
                origin: origin,
                destination: destination,
                waypoints: waypoints,
                travelMode: 'DRIVING'
            }, function(response, status) {
                if (status === 'OK') {
                    directionsDisplay.setDirections(response);
                } else {
                    window.alert('Directions request failed due to ' + status);
                }
            });
        }
    </script>
    <script async defer
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAVIHJyzMB3OZ9HPs8oQJHGHorJboK2zog&callback=initMap">
    </script>
</t:wrapper>