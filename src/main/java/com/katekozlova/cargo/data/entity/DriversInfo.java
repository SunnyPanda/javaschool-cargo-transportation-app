package com.katekozlova.cargo.data.entity;

import java.util.Objects;

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

    public DriversInfo(long allDrivers, long availableDrivers, long unavailableDrivers) {
        this.allDrivers = allDrivers;
        this.availableDrivers = availableDrivers;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriversInfo that = (DriversInfo) o;
        return allDrivers == that.allDrivers &&
                availableDrivers == that.availableDrivers &&
                unavailableDrivers == that.unavailableDrivers;
    }

    @Override
    public int hashCode() {

        return Objects.hash(allDrivers, availableDrivers, unavailableDrivers);
    }
}
