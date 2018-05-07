package com.katekozlova.cargo.data.entity;

public class DriversInfo {

    private long allDrivers;
    private long availableDrivers;
    private long unavailableDrivers;

    public long getAllDrivers() {
        return allDrivers;
    }

    public void setAllDrivers(long allDrivers) {
        this.allDrivers = allDrivers;
    }

    public long getAvailableDrivers() {
        return availableDrivers;
    }

    public void setAvailableDrivers(long availableDrivers) {
        this.availableDrivers = availableDrivers;
    }

    public long getUnavailableDrivers() {
        return unavailableDrivers;
    }

    public void setUnavailableDrivers(long unavailableDrivers) {
        this.unavailableDrivers = unavailableDrivers;
    }

    @Override
    public String toString() {
        return "DriversInfo{" +
                "allDrivers=" + allDrivers +
                ", availableDrivers=" + availableDrivers +
                ", unavailableDrivers=" + unavailableDrivers +
                '}';
    }
}
