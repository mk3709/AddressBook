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


    public void sortEnteriesByName()
    {
        Collections.sort(contacts, Comparator.comparing(contact -> contact.getFirstName() + " " + contact.getLastName()));

    }

    public void sortEntriesByNameUsingStreams()
    {

        contacts = contacts.stream()
                .sorted(Comparator.comparing(contact -> contact.getFirstName() + " " + contact.getLastName()))
                .collect(Collectors.toList());

    }

    @Override
    public String toString() {
   StringBuilder result = new StringBuilder();
for(ContactPerson contact: contacts)
{
    result.append(contact).append("\n------------------\n");
}
 return  result.toString();
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
    public int  getContactCountByCity(String city)
    {
        return cityDictionary.getOrDefault(city,Collections.emptyList()).size();
    }

    public int getContactCountByState(String state)
    {
        return stateDictionary.getOrDefault(state,Collections.emptyList()).size();

    }

    public void displayContactByCity(String city)
    {
        List<ContactPerson> contactsInCity = cityDictionary.get(city);
        if(contactsInCity!=null)
        {
            System.out.println("Contacts in "+city+":");
            contactsInCity.forEach(System.out::println);
        }
        else
        {
            System.out.println("No contacts found"+city);
        }



    }
    public void displayContactByState(String state)
    {
        List<ContactPerson> contactsInCity = cityDictionary.get(state);
        if(contactsInCity!=null)
        {
            System.out.println("Contacts in "+state+":");
            contactsInCity.forEach(System.out::println);
        }
        else
        {
            System.out.println("No contacts found"+state);
        }



    }



public Map<String,Long> countContactsByCity()
{
    return cityDictionary.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,entry ->(long)entry.getValue().size()));
}


    public Map<String,Long> countContactsByState()
    {
        return stateDictionary.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,entry ->(long)entry.getValue().size()));
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
