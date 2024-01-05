package com.day24;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        if (!isDuplicate(contact)) {
            contacts.add(contact);
            System.out.println("Contact added successfully");
        } else {
            System.out.println("Duplicate contact found, cannot add");
        }
    }

    public void editContact(String name, Contact updatedContact) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getFirstName().equals(name) || contact.getLastName().equals(name)) {
                contacts.set(i, updatedContact);
                System.out.println("Contact edited successfully");
                return;
            }
        }
        System.out.println("Contact not found");
    }

    public void deleteContact(String name) {
        contacts.removeIf(contact -> contact.getFirstName().equals(name) || contact.getLastName().equals(name));
        System.out.println("Contact deleted successfully");
    }

    public List<Contact> searchPersonsByCityOrState(String cityOrState) {
        return contacts.stream()
                .filter(contact -> contact.getCity().equals(cityOrState) || contact.getState().equals(cityOrState))
                .collect(Collectors.toList());
    }

    public void printContacts(List<Contact> contacts) {
        contacts.forEach(System.out::println);
    }

    public void printAddressBook() {
        System.out.println("Address Book:");
        contacts.forEach(System.out::println);
    }

    public boolean isDuplicate(Contact contact) {
        return contacts.stream().anyMatch(existingContact -> existingContact.equals(contact));
    }

    public void sortByName() {
        contacts.sort(Comparator.comparing(Contact::getFirstName).thenComparing(Contact::getLastName));
    }

    public void sortByCity() {
        contacts.sort(Comparator.comparing(Contact::getCity));
    }

    public void sortByState() {
        contacts.sort(Comparator.comparing(Contact::getState));
    }

    public void sortByZip() {
        contacts.sort(Comparator.comparing(Contact::getZip));
    }
}
