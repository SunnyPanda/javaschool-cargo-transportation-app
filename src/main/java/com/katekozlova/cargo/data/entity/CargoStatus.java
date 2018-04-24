package com.katekozlova.cargo.data.entity;

public enum CargoStatus {
    PREPARED("Prepared"), SHIPPED("Shipped"), DELIVERED("Delivered");

    private final String label;

    CargoStatus(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
