package com.katekozlova.cargo.data.entity;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @SequenceGenerator(name = "driver_generator", sequenceName = "driver_sequence", initialValue = 10)
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

//    @Column(name = "current_truck")
//    @ManyToOne
//    private Truck currentTruck;

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
}
