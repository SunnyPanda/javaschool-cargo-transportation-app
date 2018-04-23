package com.katekozlova.cargo.data.entity;

public enum DriverStatus {
    REST("Отдых"), IN_SHIFT("В смене"), BEHIND_THE_WHEEL("За рулем");

    private final String label;

    DriverStatus(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
