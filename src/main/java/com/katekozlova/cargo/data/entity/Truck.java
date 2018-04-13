package com.katekozlova.cargo.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "trucks")
public class Truck {
    @Id
    @Column(name = "truck_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "reg_number")
    private String regNumber;

    @Column(name = "shift_size")
    private String shiftSize;

    @Column(name = "capacity")
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
