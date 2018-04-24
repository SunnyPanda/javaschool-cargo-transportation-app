package com.katekozlova.cargo.data.entity;

import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table(name = "drivers", uniqueConstraints = @UniqueConstraint(columnNames = "personal_number"))
public class Driver {

    @Id
    @SequenceGenerator(name = "driver_generator", sequenceName = "driver_sequence", initialValue = 20)
    @GeneratedValue(generator = "driver_generator")
    private long id;

    @Column(name = "personal_number")
    private long personalNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "hours_per_month")
    private long hoursPerMonth;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private DriverStatus driverStatus;

    @ManyToOne
    @JoinColumn(name = "current_city_id")
    private City currentCity;

    @ManyToOne
    @JoinColumn(name = "current_truck_id")
    private Truck currentTruck;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToOne(mappedBy = "driver", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private User user;

    @Column(length = 300)
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
                ", hoursPerMonth=" + hoursPerMonth +
                ", driverStatus=" + driverStatus +
                ", currentCity=" + currentCity +
                ", currentTruck=" + currentTruck +
                ", order=" + order +
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
}
