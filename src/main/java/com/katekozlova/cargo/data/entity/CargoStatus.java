package com.katekozlova.cargo.data.entity;

public enum CargoStatus {
    PREPARED("Подготовлен"), SHIPPED("Отгружен"), DELIVERED("Доставлен");

    private final String label;

    CargoStatus(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
