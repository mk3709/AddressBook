package com.bridgelabz.addressbook;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ContactPerson {
    private String name;
    private String phoneNumber;
    private String email;

    public ContactPerson(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}

class AddressBook {
    private List<ContactPerson> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(ContactPerson contact) {
        contacts.add(contact);
    }

    public void displayContacts() {
        for (ContactPerson contact : contacts) {
            System.out.println(contact);
        }
    }

    public ContactPerson findContactByName(String name) {
        for (ContactPerson contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public void editContactDetails(String name, String newPhoneNumber, String newEmail) {
        ContactPerson contact = findContactByName(name);
        if (contact != null) {
            contact.setPhoneNumber(newPhoneNumber);
            contact.setEmail(newEmail);
            System.out.println("Contact details updated successfully.");
        } else {
            System.out.println("Contact not found with the given name.");
        }
    }
}

public class AddressBookMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an AddressBook instance
        AddressBook addressBook = new AddressBook();

        // Use console to add a new contact
        System.out.println("Enter details for a new contact:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        // Create a new ContactPerson
        ContactPerson newContact = new ContactPerson(name, phoneNumber, email);

        // Add the new contact to the address book
        addressBook.addContact(newContact);

        // Display the contacts in the address book
        System.out.println("\nAddress Book Contents:");
        addressBook.displayContacts();

        // Use console to edit an existing contact
        System.out.println("\nEnter the name of the contact you want to edit:");
        String contactNameToEdit = scanner.nextLine();

        // Check if the contact exists
        ContactPerson contactToEdit = addressBook.findContactByName(contactNameToEdit);
        if (contactToEdit != null) {
            System.out.println("Enter new phone number for " + contactToEdit.getName() + ": ");
            String newPhoneNumber = scanner.nextLine();
            System.out.println("Enter new email for " + contactToEdit.getName() + ": ");
            String newEmail = scanner.nextLine();

            // Edit contact details
            addressBook.editContactDetails(contactNameToEdit, newPhoneNumber, newEmail);

            // Display the updated contacts in the address book
            System.out.println("\nUpdated Address Book Contents:");
            addressBook.displayContacts();
        } else {
            System.out.println("Contact not found with the given name.");
        }

        // Close the scanner
        scanner.close();
    }
}
