package com.katekozlova.cargo.business.service;

import com.google.common.collect.ImmutableList;
import com.katekozlova.cargo.data.entity.Cargo;
import com.katekozlova.cargo.data.entity.CargoStatus;
import com.katekozlova.cargo.data.entity.Order;
import com.katekozlova.cargo.data.repository.CargoRepository;
import com.katekozlova.cargo.data.repository.WaypointRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CargoServiceTest extends MockitoJUnit {

    private static final Cargo cargo;

    static {
        Order order = new Order();
        cargo = new Cargo();
        order.setId(56);
        cargo.setId(6);
        cargo.setNumber(33);
        cargo.setName("Cat");
        cargo.setWeight(10);
        cargo.setCargoStatus(CargoStatus.SHIPPED);
        cargo.setOrder(order);
    }

    @Mock
    private CargoRepository cargoRepository;

    private CargoService service;

    @Before
    public void setUp() throws Exception {
        service = new CargoService(cargoRepository);
    }

    @Test
    public void getAllCargo() {
        List<Cargo> cargoList = ImmutableList.of(cargo);

        when(cargoRepository.findAll()).thenReturn(cargoList);
        assertEquals(cargoList, service.getAllCargo());
    }

    @Test
    public void getCargoByNumber() {

        when(cargoRepository.findByNumber(cargo.getNumber())).thenReturn(cargo);
        assertEquals(cargo, service.getCargoByNumber(cargo.getNumber()));
    }

    @Test
    public void setCargoStatus() {
        when(cargoRepository.findById(cargo.getId())).thenReturn(cargo);
        service.setCargoStatus(cargo.getId(), CargoStatus.DELIVERED);
        assertEquals(CargoStatus.DELIVERED, cargo.getCargoStatus());
    }

    @Test
    public void getFreeCargo() {
        List<Cargo> cargoList = ImmutableList.of(cargo);

        when(cargoRepository.findByNullOrder()).thenReturn(cargoList);
        assertEquals(cargoList, service.getFreeCargo());
    }

    @Test
    public void getCargoByWaypoints() {
    }
}