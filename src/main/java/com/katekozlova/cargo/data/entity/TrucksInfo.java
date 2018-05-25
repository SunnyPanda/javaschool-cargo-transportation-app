package com.katekozlova.cargo.data.entity;

public class TrucksInfo {

    private long allTrucks;
    private long availableTrucks;
    private long onOrderTrucks;
    private long brokenTrucks;

    public long getAllTrucks() {
        return allTrucks;
    }

    public void setAllTrucks(long allTrucks) {
        this.allTrucks = allTrucks;
    }

    public long getAvailableTrucks() {
        return availableTrucks;
    }

    public void setAvailableTrucks(long availableTrucks) {
        this.availableTrucks = availableTrucks;
    }

    public long getOnOrderTrucks() {
        return onOrderTrucks;
    }

    public void setOnOrderTrucks(long onOrderTrucks) {
        this.onOrderTrucks = onOrderTrucks;
    }

    public long getBrokenTrucks() {
        return brokenTrucks;
    }

    public void setBrokenTrucks(long brokenTrucks) {
        this.brokenTrucks = brokenTrucks;
    }

    public TrucksInfo(long allTrucks, long availableTrucks, long onOrderTrucks, long brokenTrucks) {
        this.allTrucks = allTrucks;
        this.availableTrucks = availableTrucks;
        this.onOrderTrucks = onOrderTrucks;
        this.brokenTrucks = brokenTrucks;
    }

    @Override
    public String toString() {
        return "TrucksInfo{" +
                "allTrucks=" + allTrucks +
                ", availableTrucks=" + availableTrucks +
                ", onOrderTrucks=" + onOrderTrucks +
                ", brokenTrucks=" + brokenTrucks +
                '}';
    }
}
