package com.katekozlova.cargo.data.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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
    private List<Waypoint> waypoints;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "order")
    private Truck truck;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private Set<Driver> drivers;

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
}
