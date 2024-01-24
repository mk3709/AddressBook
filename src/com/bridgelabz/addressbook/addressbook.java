package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;
public class addressbook{
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public addressbook(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void displayContact()
    {
        System.out.println("Name:"+firstName+" "+lastName);
        System.out.println("Address"+address);
        System.out.println("City:"+city);
        System.out.println("State"+state);
        System.out.println("Zip:"+zip);
        System.out.println("Phone Number"+phoneNumber);
        System.out.println("Email"+email);
    }

    @Override
    public String toString() {
        return "addressbook{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);



        System.out.println("Enter First Name");
        String firstName = scanner.nextLine();
        System.out.println("Enter Last Name");
        String lastName = scanner.nextLine();

        System.out.println("Enter Address: ");
        String address = scanner.nextLine();

        System.out.println("Enter City: ");
        String city = scanner.nextLine();

        System.out.println("Enter State: ");
        String state = scanner.nextLine();

        System.out.println("Enter ZIP: ");
        String zip = scanner.nextLine();

        System.out.println("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter Email: ");
        String email = scanner.nextLine();

        addressbook newContact = new addressbook(firstName, lastName, address, city, state, zip, phoneNumber, email);


        System.out.println(newContact);

        newContact.displayContact();

        scanner.close();
    }


}

