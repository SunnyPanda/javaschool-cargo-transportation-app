package com.katekozlova.cargo.data.entity;

public enum WaypointType {
    SHIPMENT("Погрузка"), LANDING("Выгрузка");

    private final String label;

    WaypointType(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
