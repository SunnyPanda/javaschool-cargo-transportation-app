package com.katekozlova.cargo.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "map_distance")
public class MapDistance {

    @Id
    @SequenceGenerator(name = "distance_generator", sequenceName = "distance_sequence", initialValue = 20)
    @GeneratedValue(generator = "distance_generator")
    private long id;

    @ManyToOne
    private City cityFrom;

    @ManyToOne
    private City cityTo;

    @Column
    private long distance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public City getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(City cityFrom) {
        this.cityFrom = cityFrom;
    }

    public City getCityTo() {
        return cityTo;
    }

    public void setCityTo(City cityTo) {
        this.cityTo = cityTo;
    }

    public long getDisrance() {
        return distance;
    }

    public void setDisrance(long disrance) {
        this.distance = disrance;
    }
}
