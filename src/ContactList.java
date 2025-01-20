// Contact List by Lily Kassaei

import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    // ArrayList that stores all contacts
    ArrayList<Person> contacts;

    // Constructor to initialize the contact list
    public ContactList() {
        this.contacts = new ArrayList<Person>();
    }

    // Getter method for the contact list
    public ArrayList<Person> getContacts() {
        return contacts;
    }

    // Method to add contact based on type (Student or Olympian)
    public void addContact(int num, String firstName, String lastName, String phoneNumber, int grade, String sport) {
        if (num == 1) {
            // Add new student contact
            Student s = new Student(firstName, lastName, phoneNumber, grade);
            contacts.add(s);
        }
        else if (num == 2){
            // Add new olympian contact
            Olympian a = new Olympian(firstName, lastName, phoneNumber, sport);
            contacts.add(a);
        }
    }

    // Helper method to prompt user input for adding contact
    public void addContactHelper() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selcect a type of contact to add:");
        System.out.println("1. Student");
        System.out.println("2. Athlete");
        int contactChoice = scanner.nextInt();
        System.out.println("Please fill in the following information.");

        // Collect the common attributes no matter the contact
        System.out.println("First Name:");
        scanner.nextLine(); // Make sure scanner moves to next line so it can read next input
        String firstName = scanner.nextLine();
        System.out.println("Last Name:");
        String lastName = scanner.nextLine();
        System.out.println("Phone Number:");
        String phoneNumber = scanner.nextLine();

        // Collect specific attributes based on contact type
        if (contactChoice == 1) {
            System.out.println("Grade:");
            int grade = scanner.nextInt();
            // If contact is a student, sport will always be null
            addContact(contactChoice, firstName, lastName, phoneNumber, grade, null);
            System.out.println("Your contact has been added");
        }
        else if (contactChoice == 2) {
            System.out.println("Sport:");
            String sport = scanner.nextLine();
            // If contact is an olympian, grade will always be -1
            addContact(contactChoice, firstName, lastName, phoneNumber, -1, sport);
            System.out.println("Your contact has been added");
        }
        else {
            System.out.println("Invalid choice");
        }
    }

    // Method to print all contacts
    public void printContacts() {
        for (Person p : contacts) {
            System.out.println(p.toString());
        }
    }

    // Method to sort contacts based on a specific attribute
    public void sort(int sortBy) {
        // Sort alphabetically by first name
        if (sortBy == 0) {
            Person temp;
            for (int i = 0; i < contacts.size(); i++) {
                for (int j = 0; j < contacts.size() - 1 - i; j++) {
                    // If the first name of the current contact is later in the alphabet than the next one, swap them
                    if (contacts.get(j).getFirstName().compareTo(contacts.get(j + 1).getFirstName()) > 0) {
                        temp = contacts.get(j);
                        contacts.set(j, contacts.get(j + 1));
                        contacts.set(j + 1, temp);
                    }
                }
            }
        }
        else if (sortBy == 1) {
            // Sort alphabetically by last name
            Person temp;
            for (int i = 0; i < contacts.size(); i++) {
                for (int j = 0; j < contacts.size() - 1 - i; j++) {
                    // If the last name of the current contact is later in the alphabet than the next one, swap them
                    if (contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName()) > 0) {
                        temp = contacts.get(j);
                        contacts.set(j, contacts.get(j + 1));
                        contacts.set(j + 1, temp);
                    }
                }
            }
        }
        else if (sortBy == 2) {
            // Sort by phone number
            Person temp;
            for (int i = 0; i < contacts.size(); i++) {
                for (int j = 0; j < contacts.size() - 1 - i; j++) {
                    // If the current contact phone number is bigger than the next one, swap them
                    if (contacts.get(j).getPhoneNumber().compareTo(contacts.get(j + 1).getPhoneNumber()) > 0) {
                        temp = contacts.get(j);
                        contacts.set(j, contacts.get(j + 1));
                        contacts.set(j + 1, temp);
                    }
                }
            }
        }
    }

    // Search for a contact by first name
    public Person searchByFirstName(String firstName) {
        for (Person p: contacts) {
            // If the current contact first name matches the given first name to search for, return the
            // current contact's info
            if (p.getFirstName().equals(firstName)) {
                return p;
            }
        }
        // If nothing is found return null
        return null;
    }

    // Search for a contact by last name
    public Person searchByLastName(String lastName) {
        for (Person p: contacts) {
            // If the current contact's last name matches the given last name to search for, return the
            // current contact's info
            if (p.getLastName().equals(lastName)) {
                return p;
            }
        }
        // If nothing is found return null
        return null;
    }

    // Search for a contact by phone number
    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person p: contacts) {
            // If the current contact's phone number matches the given phone number to search for, return the
            // current contact's info
            if (p.getPhoneNumber().equals(phoneNumber)) {
                return p;
            }
        }
        // If nothing is found return null
        return null;
    }

    // Method to list all students in the contact list
    public void listStudents() {
        ArrayList<Person> students = new ArrayList<Person>();
        for (Person p: contacts) {
            // If a person in the list of contacts is a student, add them to the list of students
            if (p instanceof Student) {
                students.add(p);
            }
        }
        // Print all students and their info
        for (Person s : students) {
            System.out.println(s.toString());
        }
    }

    public void test() {
        addContact(1, "Lily", "Kassaei", "1", 10, "tennis");
        addContact(1, "Sara", "Kassaei", "2", 10, "golf");
        addContact(2, "Baba", "Kass", "3", 100, "weights");
    }

    // Method to print the menu
    public void printMenu() {
        System.out.println("Menu:");
        System.out.println("-1: Test");
        System.out.println("1: Add Contact");
        System.out.println("2: List all contacts by First Name");
        System.out.println("3: List all contacts by Last Name");
        System.out.println("4: List all contacts by Phone Number");
        System.out.println("5: List all Students");
        System.out.println("6: Search by First Name");
        System.out.println("7: Search by Last Name");
        System.out.println("8: Search by Phone Number");
        System.out.println("0: Exit");
    }

    // Method to run the program
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean wantsExit = false;
        // Run until 0 has been selected
        while(!wantsExit) {
            // Print the menu
            printMenu();

            int choice = scanner.nextInt();

            // Exit if 0 has been selected
            if (choice == 0) {
                wantsExit = true;
            }

            // Add a contact
            else if (choice == 1) {
                addContactHelper();
            }

            // Sort by first name and print sorted list of contacts
            else if (choice == 2) {
                sort(0);
                printContacts();
            }

            // Sort by last name and print sorted list of contacts
            else if (choice == 3) {
                sort(1);
                printContacts();
            }

            // Sort by phone number and print sorted list of contacts
            else if (choice == 4) {
                sort(2);
                printContacts();
            }

            // List all students
            else if (choice == 5) {
                listStudents();
            }

            // Search by first name
            else if (choice == 6) {
                System.out.print("Enter a name:");
                scanner.nextLine(); // Move scanner to next line so it can read next input
                String firstName = scanner.nextLine();
                // If a contact with matching first name has been found, print their info
                if (searchByFirstName(firstName) != null) {
                    System.out.print(searchByFirstName(firstName));
                }
                // If no contact with matching first name has been found then specify they are not in the list
                else {
                    System.out.print(firstName + " is not in the list.\n");
                }
            }

            // Search by last name
            else if (choice == 7) {
                System.out.print("Enter a last name:");
                scanner.nextLine(); // Move scanner to next line so it can read next input
                String lastName = scanner.nextLine();
                // If a contact with matching last name has been found, print their info
                if (searchByLastName(lastName) != null) {
                    System.out.print(searchByLastName(lastName));
                }
                // If no contact with matching last name has been found then specify they are not in the list
                else {
                    System.out.print(lastName + " is not in the list.\n");
                }
            }

            // Search by phone number
            else if (choice == 8) {
                System.out.print("Enter a phone number:");
                scanner.nextLine(); // Move scanner to next line so it can read next input
                String phoneNumber = scanner.nextLine();
                // If a contact with matching phone number has been found, print their info
                if (searchByPhoneNumber(phoneNumber) != null) {
                    System.out.print(searchByPhoneNumber(phoneNumber));
                }
                // If no contact with matching phone number has been found then specify they are not in the list
                else {
                    System.out.print(phoneNumber + " is not in the list.\n");
                }
            }
            else if (choice == -1) {
                test();
            }
            else {
                System.out.println("Invalid choice.\n");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        // Create a new contact list and run program
        ContactList contactList = new ContactList();
        contactList.run();
    }
}
