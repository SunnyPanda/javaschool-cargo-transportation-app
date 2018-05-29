package com.katekozlova.cargo.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "drivers", uniqueConstraints = @UniqueConstraint(columnNames = "personal_number"))
public class Driver implements Serializable {

    private static final long serialVersionUID = 4635706921404836842L;

    @Id
    @SequenceGenerator(name = "driver_generator", sequenceName = "driver_sequence", initialValue = 20)
    @GeneratedValue(generator = "driver_generator")
    @JsonIgnore
    private long id;

    @Column(name = "personal_number")
    private long personalNumber;

    @Column(name = "first_name")
    @JsonIgnore
    private String firstName;

    @Column(name = "last_name")
    @JsonIgnore
    private String lastName;

    @Column(name = "hours_per_month")
    @JsonIgnore
    private long hoursPerMonth;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    @JsonIgnore
    private DriverStatus driverStatus;

    @ManyToOne
    @JoinColumn(name = "current_city_id")
    @JsonIgnore
    private City currentCity;

    @ManyToOne
    @JoinColumn(name = "current_truck_id")
    @JsonIgnore
    private Truck currentTruck;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Order order;

    @OneToOne(mappedBy = "driver", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnore
    private User user;

    @Column(length = 300)
    @JsonIgnore
    private DateTime shiftBegin;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(long personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", personalNumber=" + personalNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", driverStatus=" + driverStatus +
                '}';
    }

    public long getHoursPerMonth() {
        return hoursPerMonth;
    }

    public void setHoursPerMonth(long hoursPerMonth) {
        this.hoursPerMonth = hoursPerMonth;
    }

    public DriverStatus getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(DriverStatus driverStatus) {
        this.driverStatus = driverStatus;
    }

    public City getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    public Truck getCurrentTruck() {
        return currentTruck;
    }

    public void setCurrentTruck(Truck currentTruck) {
        this.currentTruck = currentTruck;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public DateTime getShiftBegin() {
        return shiftBegin;
    }

    public void setShiftBegin(DateTime shiftBegin) {
        this.shiftBegin = shiftBegin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return id == driver.id &&
                personalNumber == driver.personalNumber &&
                hoursPerMonth == driver.hoursPerMonth &&
                Objects.equals(firstName, driver.firstName) &&
                Objects.equals(lastName, driver.lastName) &&
                driverStatus == driver.driverStatus &&
                Objects.equals(currentCity, driver.currentCity) &&
                Objects.equals(currentTruck, driver.currentTruck) &&
                Objects.equals(order, driver.order);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, personalNumber, firstName, lastName, hoursPerMonth, driverStatus, currentCity, currentTruck, order);
    }
}
