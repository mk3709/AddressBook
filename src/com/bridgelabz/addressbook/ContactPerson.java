package com.bridgelabz.addressbook;

import java.util.Objects;

class ContactPerson {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public ContactPerson(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email) {

        this.firstName = firstName;

        this.lastName = lastName;

        this.address = address;

        this.city = city;

        this.state = state;

        this.zip = zip;

        this.phoneNumber = phoneNumber;

        this.email = email;
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


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {

        return city;

    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        ContactPerson that = (ContactPerson) obj;

        return (this.firstName + " " + this.lastName).equalsIgnoreCase(that.firstName + " " + that.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName);

    }


    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName +
                "\nAddress: " + address +
                "\nCity: " + city +
                "\nState: " + state +
                "\nZip: " + zip +
                "\nPhone Number: " + phoneNumber +
                "\nEmail: " + email;
    }
}
