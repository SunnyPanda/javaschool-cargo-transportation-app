package com.katekozlova.cargo.data.entity;

public enum OrderStatus {
    YES("Finished"), NO("Unfinished");

    private final String label;

    OrderStatus(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
