package com.bridgelabz.addressbook;
import java.util.ArrayList;
import java.util.Iterator;
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

    public void editContact(String name, String newPhoneNumber, String newEmail) {
        ContactPerson contact = findContactByName(name);
        if (contact != null) {
            contact.setPhoneNumber(newPhoneNumber);
            contact.setEmail(newEmail);
            System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void deleteContact(String name) {
        Iterator<ContactPerson> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            ContactPerson contact = iterator.next();
            if (contact.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }
}

public class AddressBookMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AddressBook addressBook = new AddressBook();

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add a new contact");
            System.out.println("2. Display all contacts");
            System.out.println("3. Edit a contact");
            System.out.println("4. Delete a contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    System.out.println("\nEnter details for a new contact:");
                    System.out.print("Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Phone Number: ");
                    String newPhoneNumber = scanner.nextLine();
                    System.out.print("Email: ");
                    String newEmail = scanner.nextLine();

                    ContactPerson newContact = new ContactPerson(newName, newPhoneNumber, newEmail);
                    addressBook.addContact(newContact);
                    System.out.println("Contact added successfully.");
                    break;
                case 2:
                    System.out.println("\nAddress Book Contents:");
                    addressBook.displayContacts();
                    break;
                case 3:
                    System.out.println("\nEnter details to edit an existing contact:");
                    System.out.print("Enter the name of the contact to edit: ");
                    String contactNameToEdit = scanner.nextLine();
                    ContactPerson existingContactToEdit = addressBook.findContactByName(contactNameToEdit);

                    if (existingContactToEdit != null) {
                        System.out.println("\nExisting Contact Details:\n" + existingContactToEdit);
                        System.out.print("\nEnter new phone number: ");
                        String newPhoneNumberForEdit = scanner.nextLine();
                        System.out.print("Enter new email: ");
                        String newEmailForEdit = scanner.nextLine();

                        addressBook.editContact(contactNameToEdit, newPhoneNumberForEdit, newEmailForEdit);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 4:
                    System.out.println("\nEnter details to delete an existing contact:");
                    System.out.print("Enter the name of the contact to delete: ");
                    String contactNameToDelete = scanner.nextLine();
                    addressBook.deleteContact(contactNameToDelete);
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
