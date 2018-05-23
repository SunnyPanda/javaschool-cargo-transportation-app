package com.katekozlova.cargo.data.entity;

import javax.persistence.*;

@Entity
public class Map {

    @Id
    @SequenceGenerator(name = "map_generator", sequenceName = "map_sequence", initialValue = 20)
    @GeneratedValue(generator = "map_generator")
    private long id;

    @ManyToOne
    @JoinColumn(name = "city_from_id")
    private City cityFrom;

    @ManyToOne
    @JoinColumn(name = "city_to_id")
    private City cityTo;


    private String status;
}
