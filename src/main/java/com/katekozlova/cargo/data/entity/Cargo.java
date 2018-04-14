package com.katekozlova.cargo.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "cargo")
public class Cargo {

    @Id
    @SequenceGenerator(name = "cargo_generator", sequenceName = "cargo_sequence", initialValue = 10)
    @GeneratedValue(generator = "cargo_generator")
    private long id;

    @Column(name = "cargo_number")
    private long number;

    @Column(name = "cargo_name")
    private String name;

    @Column(name = "weight")
    private long weight;

    @Column(name = "status")
    @Enumerated
    private CargoStatus cargoStatus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public CargoStatus getCargoStatus() {
        return cargoStatus;
    }

    public void setCargoStatus(CargoStatus cargoStatus) {
        this.cargoStatus = cargoStatus;
    }
}
