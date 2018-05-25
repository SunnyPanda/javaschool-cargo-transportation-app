package com.katekozlova.cargo.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "trucks")
public class Truck {

    @Id
    @SequenceGenerator(name = "truck_generator", sequenceName = "truck_sequence", initialValue = 20)
    @GeneratedValue(generator = "truck_generator")
    @JsonIgnore
    private long id;

    @Column(name = "reg_number")
    @NaturalId
    private String regNumber;

    @Column(name = "shift_size")
    @JsonIgnore
    private int shiftSize;

    @Column(name = "capacity")
    @JsonIgnore
    private long capacity;

    @Column(name = "state")
    @Enumerated(EnumType.ORDINAL)
    @JsonIgnore
    private TruckState truckState;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "currentTruck")
    @JsonIgnore
    private List<Driver> drivers;

    @ManyToOne
    @JoinColumn(name = "current_city_id")
    @JsonIgnore
    private City currentCity;

    @OneToOne
    @JsonIgnore
    private Order order;

    @Column(name = "booking_status")
    @JsonIgnore
    @Enumerated
    private BookingStatus bookingStatus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public int getShiftSize() {
        return shiftSize;
    }

    public void setShiftSize(int shiftSize) {
        this.shiftSize = shiftSize;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public TruckState getTruckState() {
        return truckState;
    }

    public void setTruckState(TruckState truckState) {
        this.truckState = truckState;
    }

    public City getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Truck truck = (Truck) o;
        return id == truck.id &&
                shiftSize == truck.shiftSize &&
                capacity == truck.capacity &&
                Objects.equals(regNumber, truck.regNumber) &&
                truckState == truck.truckState &&
                Objects.equals(drivers, truck.drivers) &&
                Objects.equals(currentCity, truck.currentCity) &&
                Objects.equals(order, truck.order);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, regNumber, shiftSize, capacity, truckState, drivers, currentCity, order);
    }
}
