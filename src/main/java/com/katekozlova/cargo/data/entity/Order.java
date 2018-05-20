package com.katekozlova.cargo.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NaturalId;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @SequenceGenerator(name = "order_generator", sequenceName = "order_sequence", initialValue = 20)
    @GeneratedValue(generator = "order_generator")
    private long id;

    @Column(name = "unique_number")
    @NaturalId
    private long uniqueNumber;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus orderStatus;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    @JsonIgnore
    private List<Waypoint> waypoints;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "order")
    private Truck truck;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
    private List<Driver> drivers;

    @Column
    @JsonIgnore
    private Long travelTime;

    private DateTime orderTime;

    public DateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(DateTime orderTime) {
        this.orderTime = orderTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(long uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    public List<Waypoint> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<Waypoint> waypoints) {
        this.waypoints = waypoints;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public long getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(long travelTime) {
        this.travelTime = travelTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", uniqueNumber=" + uniqueNumber +
                ", orderStatus=" + orderStatus +
                ", waypoints=" + waypoints +
                ", truck=" + truck +
                ", drivers=" + drivers +
                ", travelTime=" + travelTime +
                '}';
    }
}
