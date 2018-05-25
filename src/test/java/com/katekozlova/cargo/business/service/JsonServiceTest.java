package com.katekozlova.cargo.business.service;

import com.google.common.collect.ImmutableList;
import com.katekozlova.cargo.data.entity.*;
import com.katekozlova.cargo.data.repository.CargoRepository;
import com.katekozlova.cargo.data.repository.DriverRepository;
import com.katekozlova.cargo.data.repository.OrderRepository;
import com.katekozlova.cargo.data.repository.TruckRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class JsonServiceTest {

    @Mock
    private OrderRepository orderRepository;
    @Mock
    private DriverRepository driverRepository;
    @Mock
    private TruckRepository truckRepository;

    private JsonService service;

    @Before
    public void setUp() throws Exception {
        service = new JsonService(orderRepository, driverRepository, truckRepository);
    }

    @Test
    public void generateOrdersJson() {

    }

    @Test
    public void generateDriversJson() {
        Driver driver1 = new Driver();
        Driver driver2 = new Driver();
        driver1.setId(1);
        driver1.setDriverStatus(DriverStatus.IN_SHIFT);
        driver2.setId(2);
        driver2.setDriverStatus(DriverStatus.REST);

        List<Driver> allDrivers = ImmutableList.of(driver1, driver2);
        List<Driver> availableDrivers = ImmutableList.of(driver2);
        when(driverRepository.findAll()).thenReturn(allDrivers);
        when(driverRepository.findByStatus(DriverStatus.REST)).thenReturn(availableDrivers);
        assertEquals(new DriversInfo(2, 1, 1), service.generateDriversJson());
    }

    @Test
    public void generateTrucksJson() {
        Truck truck1 = new Truck();
        Truck truck2 = new Truck();
        Truck truck3 = new Truck();
        Order order = new Order();
        order.setId(1);
        truck1.setId(1);
        truck1.setTruckState(TruckState.SERVICEABLE);
        truck2.setId(2);
        truck2.setTruckState(TruckState.SERVICEABLE);
        truck2.setOrder(order);
        truck3.setId(3);
        truck3.setTruckState(TruckState.DEFECTIVE);
        truck3.setOrder(order);
        List<Truck> allTrucks = ImmutableList.of(truck1, truck2, truck3);
        List<Truck> availableTrucks = ImmutableList.of(truck1);
        List<Truck> onOrderTrucks = ImmutableList.of(truck2, truck3);
        List<Truck> brokenTrucks = ImmutableList.of(truck3);

        when(truckRepository.findAll()).thenReturn(allTrucks);
        when(truckRepository.findByOrderTruckState(TruckState.SERVICEABLE)).thenReturn(availableTrucks);
        when(truckRepository.findByOrder()).thenReturn(onOrderTrucks);
        when(truckRepository.findByState(TruckState.DEFECTIVE)).thenReturn(brokenTrucks);

        assertEquals(new TrucksInfo(3, 1, 2, 1), service.generateTrucksJson());
    }
}