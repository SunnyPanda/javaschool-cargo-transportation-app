package com.katekozlova.cargo.business.service;

import com.google.common.collect.ImmutableList;
import com.katekozlova.cargo.data.entity.Order;
import com.katekozlova.cargo.data.entity.Truck;
import com.katekozlova.cargo.data.entity.TruckState;
import com.katekozlova.cargo.data.repository.DriverRepository;
import com.katekozlova.cargo.data.repository.TruckRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class TrucksServiceTest extends MockitoJUnit {

    private static final Truck truck;
    private static final Order order;

    static {
        truck = new Truck();
        order = new Order();
        order.setId(7);
        truck.setId(9);
        truck.setRegNumber("WE98765");
        truck.setShiftSize(2);
        truck.setTruckState(TruckState.SERVICEABLE);
        truck.setOrder(order);
    }

    @Mock
    private TruckRepository truckRepository;
    @Mock
    private DriverRepository driverRepository;

    private TrucksService service;

    @Before
    public void setUp() throws Exception {
        service = new TrucksService(truckRepository, driverRepository);
    }

    @Test
    public void getAllTrucks() {
        final List<Truck> trucks = ImmutableList.of(truck);

        when(truckRepository.findAll()).thenReturn(trucks);
        assertEquals(trucks, service.getAllTrucks());
    }

    @Test
    public void deleteTruck() {

        service.deleteTruck(truck);
        verify(truckRepository).delete(truck);
    }

    @Test
    public void createAndUpdate() {

        Truck tempTruck = new Truck();
        tempTruck.setRegNumber("WE98765");
        tempTruck.setShiftSize(2);
        tempTruck.setTruckState(TruckState.SERVICEABLE);
        when(truckRepository.save(tempTruck)).thenReturn(truck);
        assertEquals(truck, service.createAndUpdate(tempTruck));

        Truck savedTruck = new Truck();
        savedTruck.setId(9);
        savedTruck.setRegNumber("WE98654");
        savedTruck.setShiftSize(3);
        savedTruck.setTruckState(TruckState.DEFECTIVE);
        when(truckRepository.save(truck)).thenReturn(savedTruck);
        assertEquals(savedTruck, service.createAndUpdate(truck));
    }

    @Test
    public void findById() {

        when(truckRepository.findById(truck.getId())).thenReturn(truck);
        assertEquals(truck, service.findById(9));
    }

    @Test
    public void getTrucksByState() {
        final List<Truck> trucks = ImmutableList.of(truck);
        when(truckRepository.findByState(truck.getTruckState())).thenReturn(trucks);
        assertEquals(trucks, service.getTrucksByState(TruckState.SERVICEABLE));
    }

    @Test
    public void getTrucksWithOrder() {
        final List<Truck> trucks = ImmutableList.of(truck);

        when(truckRepository.findByOrder()).thenReturn(trucks);
        assertEquals(trucks, service.getTrucksWithOrder());
    }

    @Test
    public void availableTrucks() {
        Truck tempTruck = new Truck();
        tempTruck.setRegNumber("WE98765");
        tempTruck.setShiftSize(2);
        tempTruck.setTruckState(TruckState.SERVICEABLE);

        final List<Truck> trucks = ImmutableList.of(tempTruck);

        when(truckRepository.findByOrderTruckState(tempTruck.getTruckState())).thenReturn(trucks);
        assertEquals(trucks, service.availableTrucks(TruckState.SERVICEABLE));
    }
}