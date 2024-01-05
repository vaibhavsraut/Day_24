package com.day24;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookMain {
    private Map<String, AddressBook> addressBooks;

    public AddressBookMain() {
        this.addressBooks = new java.util.HashMap<>();
    }

    public void createAddressBook(String name) {
        AddressBook addressBook = new AddressBook();
        addressBooks.put(name, addressBook);
        System.out.println("Address book created");
    }

    public void addContact(String addressBookName, Contact contact) {
        AddressBook addressBook = addressBooks.get(addressBookName);
        if (addressBook != null) {
            addressBook.addContact(contact);
        } else {
            System.out.println("Address book not found");
        }
    }

    public void editContact(String addressBookName, String name, Contact updatedContact) {
        AddressBook addressBook = addressBooks.get(addressBookName);
        if (addressBook != null) {
            addressBook.editContact(name, updatedContact);
        } else {
            System.out.println("Address book not found");
        }
    }

    public void deleteContact(String addressBookName, String name) {
        AddressBook addressBook = addressBooks.get(addressBookName);
        if (addressBook != null) {
            addressBook.deleteContact(name);
        } else {
            System.out.println("Address book not found");
        }
    }

    public void searchPersonsByCityOrState(String addressBookName, String cityOrState) {
        AddressBook addressBook = addressBooks.get(addressBookName);
        if (addressBook != null) {
            List<Contact> result = addressBook.searchPersonsByCityOrState(cityOrState);
            if (!result.isEmpty()) {
                System.out.println("Search Results:");
                printContacts(result);
            } else {
                System.out.println("No contacts found in the given city or state");
            }
        } else {
            System.out.println("Address book not found");
        }
    }

    public void printContacts(List<Contact> contacts) {
        contacts.forEach(System.out::println);
    }

    public void printAddressBook(String addressBookName) {
        AddressBook addressBook = addressBooks.get(addressBookName);
        if (addressBook != null) {
            addressBook.printAddressBook();
        } else {
            System.out.println("Address book not found");
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Address Book System");
            System.out.println("1. Create Address Book");
            System.out.println("2. Add Contact");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Search Persons By City or State");
            System.out.println("6. Print Address Book");
            System.out.println("7. Search Persons By City or State (Multiple Address Books)");
            System.out.println("8. Count Persons By City or State");
            System.out.println("9. Sort Entries Alphabetically");
            System.out.println("10. Sort Entries By City, State, or Zip");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter address book name: ");
                    String addressBookName = scanner.nextLine();
                    createAddressBook(addressBookName);
                    break;
                case 2:
                    System.out.print("Enter address book name: ");
                    addressBookName = scanner.nextLine();

                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();

                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();

                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();

                    System.out.print("Enter city: ");
                    String city = scanner.nextLine();

                    System.out.print("Enter state: ");
                    String state = scanner.nextLine();

                    System.out.print("Enter zip: ");
                    String zip = scanner.nextLine();

                    System.out.print("Enter phone number:");
                    String phoneNumber = scanner.nextLine();

                    System.out.print("Enter email:");
                    String email = scanner.nextLine();

                    Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
                    addContact(addressBookName, contact);
                    break;
                case 3:
                    System.out.print("Enter address book name: ");
                    addressBookName = scanner.nextLine();

                    System.out.print("Enter contact name: ");
                    String contactName = scanner.nextLine();

                    System.out.print("Enter updated first name: ");
                    firstName = scanner.nextLine();

                    System.out.print("Enter updated last name: ");
                    lastName = scanner.nextLine();

                    System.out.print("Enter updated address: ");
                    address = scanner.nextLine();

                    System.out.print("Enter updated city: ");
                    city = scanner.nextLine();

                    System.out.print("Enter updated state: ");
                    state = scanner.nextLine();

                    System.out.print("Enter updated zip: ");
                    zip = scanner.nextLine();

                    System.out.print("Enter updated phone number: ");
                    phoneNumber = scanner.nextLine();

                    System.out.print("Enter updated email: ");
                    email = scanner.nextLine();

                    Contact updatedContact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
                    editContact(addressBookName, contactName, updatedContact);
                    break;
                case 4:
                    System.out.print("Enter address book name: ");
                    addressBookName = scanner.nextLine();

                    System.out.print("Enter contact name: ");
                    contactName = scanner.nextLine();

                    deleteContact(addressBookName, contactName);
                    break;
                case 5:
                    System.out.print("Enter address book name: ");
                    addressBookName = scanner.nextLine();

                    System.out.print("Enter city or state: ");
                    String cityOrState = scanner.nextLine();

                    searchPersonsByCityOrState(addressBookName, cityOrState);
                    break;
                case 6:
                    System.out.print("Enter address book name: ");
                    addressBookName = scanner.nextLine();

                    printAddressBook(addressBookName);
                    break;
                case 7:
                    System.out.print("Enter city or state: ");
                    cityOrState = scanner.nextLine();

                    viewPersonsByCityOrState(cityOrState);
                    break;
                case 8:
                    System.out.print("Enter city or state: ");
                    cityOrState = scanner.nextLine();

                    countByCityOrState(cityOrState);
                    break;
                case 9:
                    System.out.print("Enter address book name: ");
                    addressBookName = scanner.nextLine();

                    sortEntriesAlphabetically(addressBookName);
                    break;
                case 10:
                    System.out.print("Enter address book name: ");
                    addressBookName = scanner.nextLine();

                    System.out.print("Enter sort option (city, state, or zip): ");
                    String sortBy = scanner.nextLine();

                    sortEntries(addressBookName, sortBy);
                    break;
                case 0:
                    System.out.println("Exiting Address Book System");
                    return;
                default:
                    System.out.println("Invalid choice");
            }

            System.out.println();
        }
    }

    public void viewPersonsByCityOrState(String cityOrState) {
        List<Contact> allContacts = addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.searchPersonsByCityOrState(cityOrState).stream())
                .collect(Collectors.toList());

        if (!allContacts.isEmpty()) {
            System.out.println("Search Results across all Address Books:");
            printContacts(allContacts);
        } else {
            System.out.println("No contacts found in the given city or state across all Address Books");
        }
    }

    public void countByCityOrState(String cityOrState) {
        long totalCount = addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.searchPersonsByCityOrState(cityOrState).stream())
                .count();

        System.out.println("Total number of contacts in the given city or state: " + totalCount);
    }

    public void sortEntriesAlphabetically(String addressBookName) {
        AddressBook addressBook = addressBooks.get(addressBookName);
        if (addressBook != null) {
            addressBook.sortByName();
            System.out.println("Entries sorted alphabetically by name");
        } else {
            System.out.println("Address book not found");
        }
    }

    public void sortEntries(String addressBookName, String sortBy) {
        AddressBook addressBook = addressBooks.get(addressBookName);
        if (addressBook != null) {
            switch (sortBy.toLowerCase()) {
                case "city":
                    addressBook.sortByCity();
                    System.out.println("Entries sorted by city");
                    break;
                case "state":
                    addressBook.sortByState();
                    System.out.println("Entries sorted by state");
                    break;
                case "zip":
                    addressBook.sortByZip();
                    System.out.println("Entries sorted by zip");
                    break;
                default:
                    System.out.println("Invalid sort option. Supported options: city, state, zip");
            }
        } else {
            System.out.println("Address book not found");
        }
    }

    public static void main(String[] args) {
        AddressBookMain addressBookMain = new AddressBookMain();
        addressBookMain.run();
    }
}
