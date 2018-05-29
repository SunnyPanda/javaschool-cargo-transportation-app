package com.katekozlova.cargo.business.service;

import com.google.common.collect.ImmutableList;
import com.katekozlova.cargo.data.entity.*;
import com.katekozlova.cargo.data.repository.WaypointRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WaypointServiceTest extends MockitoJUnit {

    private static final Waypoint waypoint;
    private static final City city;
    private static final Order order;
    private static final Cargo cargo;

    static {
        order = new Order();
        waypoint = new Waypoint();
        cargo = new Cargo();
        order.setId(45);
        city = new City();
        city.setId(3);
        city.setName("St. Petersburg");
        waypoint.setId(7);
        waypoint.setCity(city);
        waypoint.setWaypointType(WaypointType.SHIPMENT);
        waypoint.setOrder(order);
    }

    @Mock
    private WaypointRepository waypointRepository;
    private WaypointService service;

    @Before
    public void setUp() throws Exception {
        service = new WaypointService(waypointRepository);
    }

    @Test
    public void getAllWaypoints() {
        final List<Waypoint> waypoints = ImmutableList.of(waypoint);

        when(waypointRepository.findAll()).thenReturn(waypoints);

        assertEquals(waypoints, service.getAllWaypoints());
    }

    @Test
    public void createWaypoint() {

        Waypoint tempWaypoint = new Waypoint();
        tempWaypoint.setCity(city);
        tempWaypoint.setWaypointType(WaypointType.SHIPMENT);

        when(waypointRepository.save(tempWaypoint)).thenReturn(waypoint);
        assertEquals(waypoint, service.createWaypoint(tempWaypoint));
    }

    @Test
    public void getCargoByWaypoints() {
        final List<Waypoint> waypoints = ImmutableList.of(waypoint);

        when(waypointRepository.findWaypointsByOrderWaypointType(waypoint.getOrder().getId(), WaypointType.SHIPMENT))
                .thenReturn(waypoints);
        assertEquals(waypoints, service.getCargoByWaypoints(45));
    }
}