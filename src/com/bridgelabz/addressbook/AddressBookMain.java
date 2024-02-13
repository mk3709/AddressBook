package com.bridgelabz.addressbook;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {
    private Map<String, AddressBook> addressBooks;  // Map to store Address Books by name
    private Scanner scanner;

    public AddressBookMain() {
        this.addressBooks = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void addAddressBook() {
        System.out.print("Enter the unique name for the new Address Book: ");
        String addressBookName = scanner.nextLine();

        if (addressBooks.containsKey(addressBookName)) {
            System.out.println("Address Book with this name already exists. Please choose a unique name.");
            return;
        }

        AddressBook newAddressBook = new AddressBook();
        addressBooks.put(addressBookName, newAddressBook);
        System.out.println("New Address Book created successfully with the name: " + addressBookName);
    }

    public void searchPersonByCityOrStateAcrossAddressBooks(String cityOrState) {
        List<ContactPerson> searchResults = addressBooks.values().stream().flatMap(addAddressBook -> addAddressBook.searchPersonByCityOrState(cityOrState).stream()).collect(Collectors.toList());

        if (searchResults.isEmpty())
        {       System.out.println("No results found for the given city or state");
    }
        else
        {
            System.out.println("Search for the city or state"+cityOrState);
            searchResults.forEach(System.out::println);
        }
    }




    public void operateAddressBook(String addressBookName) {
        AddressBook addressBook = addressBooks.get(addressBookName);
        if (addressBook == null) {
            System.out.println("Address Book with the name " + addressBookName + " does not exist.");
            return;
        }

        while (true) {
            System.out.println("\nOptions for Address Book: " + addressBookName);
            System.out.println("1. Add a new contact");
            System.out.println("2. Display all contacts");
            System.out.println("3. Edit a contact");
            System.out.println("4. Delete a contact");
            System.out.println("5. Back to main menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    System.out.println("\nEnter details for a new contact:");
                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Address: ");
                    String address = scanner.nextLine();
                    System.out.print("City: ");
                    String city = scanner.nextLine();
                    System.out.print("State: ");
                    String state = scanner.nextLine();
                    System.out.print("ZIP: ");
                    String zip = scanner.nextLine();
                    System.out.print("Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    ContactPerson newContact = new ContactPerson(firstName, lastName, address, city, state, zip, phoneNumber, email);
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

               ;


                    if (existingContactToEdit != null) {
                        System.out.println("\nExisting Contact Details:\n" + existingContactToEdit);
                        System.out.print("\nEnter new phone number: ");
                        String newPhoneNumber = scanner.nextLine();
                        System.out.print("Enter new email: ");
                        String newEmail = scanner.nextLine();

                        addressBook.editContact(contactNameToEdit, newPhoneNumber, newEmail);
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
                    System.out.println("Returning to the main menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    public static void main(String[] args) {
        AddressBookMain addressBookMain = new AddressBookMain();
        Scanner scanner = addressBookMain.scanner;

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Add a new Address Book");
            System.out.println("2. Operate on an existing Address Book");
            System.out.println("3. Search for contacts in a specific city or state");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    addressBookMain.addAddressBook();
                    break;
                case 2:
                    System.out.print("Enter the name of the Address Book to operate on: ");
                    String addressBookName = scanner.nextLine();
                    addressBookMain.operateAddressBook(addressBookName);
                    break;
                case 3:

                    System.out.print("Enter the city or state to search for contacts: ");
                    String cityOrStateToSearch = scanner.nextLine();
                    addressBookMain.searchPersonByCityOrStateAcrossAddressBooks(cityOrStateToSearch);
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
