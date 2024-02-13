package com.bridgelabz.addressbook;

import java.util.*;
import java.util.stream.Collectors;

class AddressBook {
    private List<ContactPerson> contacts;

    private Map<String, List<ContactPerson>> cityDictionary;
    private Map<String, List<ContactPerson>> stateDictionary;

    public AddressBook() {

        this.contacts = new ArrayList<>();
        this.cityDictionary = new HashMap<>();
        this.stateDictionary = new HashMap<>();

    }

    public boolean isDuplicate(ContactPerson contact) {
        return contacts.contains(contact);
    }

    public void addContact(ContactPerson contact) {
        if (!isDuplicate(contact)) {
            contacts.add(contact);
            updateCityDictionary(contact);
            updateStateDictionary(contact);
            System.out.println("Contact added successfully.");
        } else {
            System.out.println("Duplicate entry. Contact with the same name already exists.");
        }
    }

    public ContactPerson findContactByName(String name) {
        for (ContactPerson contact : contacts) {
            if ((contact.getFirstName() + " " + contact.getLastName()).equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public void updateCityDictionary(ContactPerson contact) {

        cityDictionary.computeIfAbsent(contact.getCity(),k->new ArrayList<>()).add(contact);

    }

    public void updateStateDictionary(ContactPerson contact) {

        stateDictionary.computeIfAbsent(contact.getState(),k->new ArrayList<>()).add(contact);

    }

    public void displayContacts() {
        for (ContactPerson contact : contacts) {
            System.out.println(contact);
            System.out.println("----------------------");
        }
    }

    public List<ContactPerson> getCityName(String city) {
        return cityDictionary.getOrDefault(city,Collections.emptyList());

    }
    public  List<ContactPerson> getStateName(String state)
    {
        return stateDictionary.getOrDefault(state,Collections.emptyList());

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
            if ((contact.getFirstName() + " " + contact.getLastName()).equalsIgnoreCase(name)) {
                iterator.remove();
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public List<ContactPerson> searchPersonByCityOrState(String cityOrState) {
        return contacts.stream().filter(contact -> contact.getCity().equalsIgnoreCase(cityOrState) || contact.getState().equalsIgnoreCase(cityOrState)).collect(Collectors.toList());


    }
}
