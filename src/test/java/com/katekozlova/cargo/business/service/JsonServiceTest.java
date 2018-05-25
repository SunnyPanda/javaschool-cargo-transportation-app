package com.katekozlova.cargo.business.service;

import com.katekozlova.cargo.data.repository.CargoRepository;
import com.katekozlova.cargo.data.repository.DriverRepository;
import com.katekozlova.cargo.data.repository.OrderRepository;
import com.katekozlova.cargo.data.repository.TruckRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class JsonServiceTest {

    @Mock
    private OrderRepository orderRepository;
    @Mock
    private DriverRepository driverRepository;
    @Mock
    private CargoRepository cargoRepository;
    @Mock
    private TruckRepository truckRepository;

    private JsonService service;

    @Before
    public void setUp() throws Exception {
        service = new JsonService(orderRepository, driverRepository, cargoRepository, truckRepository);
    }

    @Test
    public void generateOrdersJson() {
    }

    @Test
    public void generateDriversJson() {
    }

    @Test
    public void generateTrucksJson() {
    }
}