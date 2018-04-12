package com.katekozlova.cargo.business.domain;

public class ListOfDrivers {
    private long driverId;
    private long personalNumber;
    private String firstName;
    private String lastName;

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
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


}
