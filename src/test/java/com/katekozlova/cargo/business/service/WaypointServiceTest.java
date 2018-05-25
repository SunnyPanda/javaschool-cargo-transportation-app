package com.katekozlova.cargo.business.service;

import com.google.common.collect.ImmutableList;
import com.katekozlova.cargo.data.entity.City;
import com.katekozlova.cargo.data.entity.Waypoint;
import com.katekozlova.cargo.data.repository.WaypointRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WaypointServiceTest extends MockitoJUnit {

    private static final Waypoint waypoint;

    static {
        final City city = new City();
        city.setId(3);
        city.setName("St. Petersburg");
        waypoint = new Waypoint();
        waypoint.setId(7);
        waypoint.setCity(city);
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
        service.createWaypoint(waypoint);
        verify(waypointRepository).save(waypoint);
    }
}