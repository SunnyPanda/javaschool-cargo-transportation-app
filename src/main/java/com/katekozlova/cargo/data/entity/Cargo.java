package com.katekozlova.cargo.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
//@Data
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

    @OneToMany(mappedBy = "cargo", cascade = CascadeType.ALL)
    private List<Waypoint> waypoints;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Order order;

    @Column(name = "booking_status")
    @JsonIgnore
    @Enumerated
    private BookingStatus bookingStatus;

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

    public List<Waypoint> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<Waypoint> waypoints) {
        this.waypoints = waypoints;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return id == cargo.id &&
                number == cargo.number &&
                weight == cargo.weight &&
                Objects.equals(name, cargo.name) &&
                cargoStatus == cargo.cargoStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, name, weight, cargoStatus);
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", cargoStatus=" + cargoStatus +
//                ", waypoints=" + waypoints +
                ", order=" + order +
//                ", bookingStatus=" + bookingStatus +
                '}';

    }
}
