package com.katekozlova.cargo.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @SequenceGenerator(name = "city_generator", sequenceName = "city_sequence", initialValue = 10)
    @GeneratedValue(generator = "city_generator")
    private long id;

    @Column(name = "city_name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

