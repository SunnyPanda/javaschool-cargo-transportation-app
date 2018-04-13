package com.katekozlova.cargo.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "TRUCK")
public class Truck {
    @Id
    @Column(name = "TRUCK_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "REG_NUMBER")
    private String regNumber;

    @Column(name = "SHIFT_SIZE")
    private String shiftSize;

    @Column(name = "CAPACITY")
    private String capacity;

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
}
