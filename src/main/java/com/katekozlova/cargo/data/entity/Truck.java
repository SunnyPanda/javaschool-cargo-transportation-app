package com.katekozlova.cargo.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "trucks")
public class Truck {

    @Id
    @SequenceGenerator(name = "truck_generator", sequenceName = "truck_sequence", initialValue = 10)
    @GeneratedValue(generator = "truck_generator")
    private long id;

    @Column(name = "reg_number")
    private String regNumber;

    @Column(name = "shift_size")
    private String shiftSize;

    @Column(name = "capacity")
    private String capacity;

    @Column(name = "state")
    @Enumerated(EnumType.ORDINAL)
    private TruckState truckState;

    @ManyToOne
    private City currentCity;

    @OneToOne
    private Order order;

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

    public String getShiftSize() {
        return shiftSize;
    }

    public void setShiftSize(String shiftSize) {
        this.shiftSize = shiftSize;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
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
}
