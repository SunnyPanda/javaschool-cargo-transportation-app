package com.katekozlova.cargo.data.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @SequenceGenerator(name = "city_generator", sequenceName = "city_sequence", initialValue = 20)
    @GeneratedValue(generator = "city_generator")
    private long id;

    @Column(name = "city_name")
    private String name;

    //    @OneToMany(mappedBy = "currentCity", fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "currentCity", cascade = CascadeType.REMOVE)
    private List<Driver> drivers;

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

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }
}

