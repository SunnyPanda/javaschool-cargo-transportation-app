package com.katekozlova.cargo.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Map {

    @Id
    @SequenceGenerator(name = "map_generator", sequenceName = "map_sequence", initialValue = 20)
    @GeneratedValue(generator = "map_generator")
    private long id;


}
