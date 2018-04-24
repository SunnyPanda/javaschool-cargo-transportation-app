package com.katekozlova.cargo.data.entity;

public enum DriverStatus {
    REST("Rest"), IN_SHIFT("In shift"), BEHIND_THE_WHEEL("Behind the wheel");

    private final String label;

    DriverStatus(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
