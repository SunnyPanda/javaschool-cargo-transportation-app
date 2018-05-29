package com.katekozlova.cargo.business.service;

import com.google.common.collect.ImmutableList;
import com.katekozlova.cargo.data.entity.Driver;
import com.katekozlova.cargo.data.entity.DriverStatus;
import com.katekozlova.cargo.data.entity.Truck;
import com.katekozlova.cargo.data.repository.DriverRepository;
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
public class DriversServiceTest extends MockitoJUnit {

    private static final Driver driver;
    private static final Truck truck;

    static {
        driver = new Driver();
        truck = new Truck();
        truck.setId(5);
        driver.setId(6);
        driver.setPersonalNumber(345);
        driver.setDriverStatus(DriverStatus.IN_SHIFT);
        driver.setHoursPerMonth(67);

    }

    @Mock
    private DriverRepository driverRepository;
    private DriversService service;

    @Before
    public void setUp() throws Exception {
        service = new DriversService(driverRepository);
    }

    @Test
    public void getAllDrivers() {
        final List<Driver> drivers = ImmutableList.of(driver);

        when(driverRepository.findAll()).thenReturn(drivers);
        assertEquals(drivers, service.getAllDrivers());
    }

    @Test
    public void deleteDriver() {

        service.deleteDriver(driver);
        verify(driverRepository).delete(driver);
    }

    @Test
    public void updateDriver() {

        Driver savedDriver = new Driver();
        savedDriver.setId(6);
        savedDriver.setPersonalNumber(768);
        savedDriver.setDriverStatus(DriverStatus.REST);
        savedDriver.setHoursPerMonth(100);

        when(driverRepository.save(driver)).thenReturn(savedDriver);
        assertEquals(savedDriver, service.updateDriver(driver));
    }

    @Test
    public void createDriver() {
        Driver tempDriver = new Driver();
        tempDriver.setPersonalNumber(345);
        tempDriver.setDriverStatus(DriverStatus.IN_SHIFT);
        tempDriver.setHoursPerMonth(67);

        when(driverRepository.save(tempDriver)).thenReturn(driver);
        assertEquals(driver, service.createDriver(tempDriver));
    }

    @Test
    public void findDriverById() {
        when(driverRepository.findById(driver.getId())).thenReturn(driver);
        assertEquals(driver, service.findDriverById(6));
    }

    @Test
    public void getDriversByStatus() {
        List<Driver> drivers = ImmutableList.of(driver);

        when(driverRepository.findByStatus(DriverStatus.IN_SHIFT)).thenReturn(drivers);
        assertEquals(drivers, service.getDriversByStatus(DriverStatus.IN_SHIFT));
    }
}