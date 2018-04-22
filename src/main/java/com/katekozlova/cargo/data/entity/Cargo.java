package com.katekozlova.cargo.data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cargo")
public class Cargo {
    @Id
    @SequenceGenerator(name = "cargo_generator", sequenceName = "cargo_sequence", initialValue = 11)
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
}
