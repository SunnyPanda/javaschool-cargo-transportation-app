package com.katekozlova.cargo.business.service;

import com.google.common.collect.ImmutableList;
import com.katekozlova.cargo.data.entity.*;
import com.katekozlova.cargo.data.repository.DriverRepository;
import com.katekozlova.cargo.data.repository.OrderRepository;
import com.katekozlova.cargo.data.repository.TruckRepository;
import com.katekozlova.cargo.data.repository.WaypointRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest extends MockitoJUnit {

    private static final Order order;
    private static final Truck truck;
    private static final City city1;
    private static final City city2;
    private static final City city3;
    private static final Cargo cargo1;
    private static final Cargo cargo2;
    private static final Waypoint waypoint1;
    private static final Waypoint waypoint2;
    private static final Waypoint waypoint3;
    private static final Waypoint waypoint4;
    private static final Driver driver;

    static {
        order = new Order();
        truck = new Truck();
        city1 = new City();
        city2 = new City();
        city3 = new City();
        cargo1 = new Cargo();
        cargo2 = new Cargo();
        waypoint1 = new Waypoint();
        waypoint2 = new Waypoint();
        waypoint3 = new Waypoint();
        waypoint4 = new Waypoint();
        driver = new Driver();
        city1.setId(25);
        city1.setName("St Petersburg");
        city2.setId(26);
        city2.setName("Moscow");
        city3.setId(27);
        city3.setName("Ekaterinburg");
        cargo1.setId(21);
        cargo1.setWeight(3);
        cargo2.setId(22);
        cargo2.setWeight(5);
        waypoint1.setId(11);
        waypoint1.setCity(city1);
        waypoint1.setCargo(cargo1);
        waypoint1.setWaypointType(WaypointType.SHIPMENT);
        waypoint2.setId(12);
        waypoint2.setCity(city2);
        waypoint2.setCargo(cargo2);
        waypoint2.setWaypointType(WaypointType.SHIPMENT);
        waypoint3.setId(13);
        waypoint3.setCity(city2);
        waypoint3.setCargo(cargo1);
        waypoint3.setWaypointType(WaypointType.LANDING);
        waypoint4.setId(14);
        waypoint4.setCity(city3);
        waypoint4.setCargo(cargo2);
        waypoint4.setWaypointType(WaypointType.LANDING);
        truck.setId(45);
        truck.setCapacity(10);
        truck.setCurrentCity(city1);
        driver.setId(31);
        driver.setCurrentCity(city1);
        order.setId(5);
        order.setUniqueNumber(456);
        order.setTruck(truck);
    }

    @Mock
    private OrderRepository orderRepository;
    @Mock
    private WaypointRepository waypointRepository;
    @Mock
    private DriverRepository driverRepository;
    @Mock
    private TruckRepository truckRepository;

    private OrderService service;

    @Before
    public void setUp() throws Exception {
        service = new OrderService(orderRepository,waypointRepository, driverRepository, truckRepository);
    }

    @Test
    public void getAllOrders() {
        List<Order> orders = ImmutableList.of(order);

        when(orderRepository.findAll()).thenReturn(orders);
        assertEquals(orders, service.getAllOrders());
    }

    @Test
    public void findById() {

        when(orderRepository.findById(order.getId())).thenReturn(order);
        assertEquals(order, service.findById(5));
    }

    @Test
    public void findByUniqueNumber() {
        when(orderRepository.findByUniqueNumber(order.getUniqueNumber())).thenReturn(order);
        assertEquals(order, service.findByUniqueNumber(456));
    }

    @Test
    public void getOrderWaypoints() {

        Waypoint waypoint = new Waypoint();
        waypoint.setId(1);
        waypoint.setOrder(order);
        List<Waypoint> waypoints = ImmutableList.of(waypoint);
        when(waypointRepository.findByOrder(order.getId())).thenReturn(waypoints);
        assertEquals(waypoints, service.getOrderWaypoints(5));
    }

    @Test
    public void getOrdersDrivers() {

        Driver driver = new Driver();
        driver.setId(67);
        driver.setOrder(order);
        List<Driver> drivers = ImmutableList.of(driver);
        when(driverRepository.findByOrder(order.getId())).thenReturn(drivers);
        assertEquals(drivers, service.getOrdersDrivers(5));
    }

    @Test
    public void getDriveDist() {
    }

    @Test
    public void create() {
        Order tempOrder = new Order();
        tempOrder.setUniqueNumber(456);
        when(orderRepository.save(tempOrder)).thenReturn(order);
        assertEquals(order, service.create(tempOrder));
    }

    @Test
    public void getTrucks() {

        List<Waypoint> waypoints = ImmutableList.of(waypoint1, waypoint2, waypoint3, waypoint4);
        order.setWaypoints(waypoints);
        List<Truck> trucks = ImmutableList.of(truck);

        when(truckRepository.findByOrderTruckStateCapacity(TruckState.SERVICEABLE, 8)).thenReturn(trucks);
        assertEquals(trucks, service.getTrucks(order));
    }

    @Test
    public void saveTruckToOrder() {

        service.saveTruckToOrder(order);
        verify(truckRepository).save(truck);
    }

    @Test
    public void getDrivers() {
        List<Waypoint> waypoints = ImmutableList.of(waypoint1, waypoint2, waypoint3, waypoint4);
        order.setWaypoints(waypoints);

        List<Driver> drivers = ImmutableList.of(driver);
        when(driverRepository.findByOrderAndCurrentCity(25)).thenReturn(drivers);
        assertEquals(drivers, service.getDrivers(order));
    }

    @Test
    public void saveOrder() {
        List<Driver> drivers = ImmutableList.of(driver);
        order.setDrivers(drivers);
        List<Waypoint> waypoints = ImmutableList.of(waypoint1, waypoint2, waypoint3, waypoint4);
        order.setWaypoints(waypoints);
        service.saveOrder(order);
        verify(orderRepository).save(order);
    }

    @Test
    public void setExistingOrdersTravelTime() {

        service.setExistingOrdersTravelTime();
        verify(orderRepository).findAll();
    }

    @Test
    public void getDriversByHours() {
    }

    @Test
    public void saveWaipoints() {
    }


    @Test
    public void getOrderToDriver() {
    }

    @Test
    public void getTruckToDriver() {
    }

    @Test
    public void saveDriversToOrder() {
    }

    @Test
    public void getOrderIdToWaypoint() {

    }

    @Test
    public void getTravelTime() {
    }
}