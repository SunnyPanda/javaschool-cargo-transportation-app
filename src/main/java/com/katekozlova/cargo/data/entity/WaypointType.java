package com.katekozlova.cargo.data.entity;

public enum WaypointType {
    SHIPMENT("Shipment"), LANDING("Landing");

    private final String label;

    WaypointType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public String getName() {
        return name();
    }

    @Override
    public String toString() {
        return label;
    }
}
