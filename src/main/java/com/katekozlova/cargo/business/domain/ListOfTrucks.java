package com.katekozlova.cargo.business.domain;

public class ListOfTrucks {
    private long truckId;
    private String regNumber;
    private String shiftSize;
    private String capacity;

    public long getTruckId() {
        return truckId;
    }

    public void setTruckId(long truckId) {
        this.truckId = truckId;
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
