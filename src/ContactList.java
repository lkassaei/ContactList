
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    ArrayList<Person> contacts;

    public ContactList() {
        this.contacts = new ArrayList<Person>();
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact(int num, String firstName, String lastName, String phoneNumber, int grade, String sport) {
        if (num == 1) {
            Student s = new Student(firstName, lastName, phoneNumber, grade);
            contacts.add(s);
        }
        else if (num == 2){
            Olympian a = new Olympian(firstName, lastName, phoneNumber, sport);
            contacts.add(a);
        }
    }

    public void addContactHelper() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selcect a type of contact to add:");
        System.out.println("1. Student");
        System.out.println("2. Athlete");
        int contactChoice = scanner.nextInt();
        System.out.println("Please fill in the following information.");
        System.out.println("First Name:");
        scanner.nextLine();
        String firstName = scanner.nextLine();
        System.out.println("Last Name:");
        String lastName = scanner.nextLine();
        System.out.println("Phone Number:");
        String phoneNumber = scanner.nextLine();
        if (contactChoice == 1) {
            System.out.println("Grade:");
            int grade = scanner.nextInt();
            addContact(contactChoice, firstName, lastName, phoneNumber, grade, null);
            System.out.println("Your contact has been added");
        }
        else if (contactChoice == 2) {
            System.out.println("Sport:");
            String sport = scanner.nextLine();
            addContact(contactChoice, firstName, lastName, phoneNumber, -1, sport);
            System.out.println("Your contact has been added");
        }
        else {
            System.out.println("Invalid choice");
        }
    }

    public void printContacts() {
        for (Person p : contacts) {
            System.out.println(p.toString());
        }
    }

    public void sort(int sortBy) {
        if (sortBy == 0) {
            // Sort by first name
            Person temp;
            for (int i = 0; i < contacts.size(); i++) {
                for (int j = 0; j < contacts.size() - 1 - i; j++) {
                    if (contacts.get(j).getFirstName().compareTo(contacts.get(j + 1).getFirstName()) > 0) {
                        temp = contacts.get(j);
                        contacts.set(j, contacts.get(j + 1));
                        contacts.set(j + 1, temp);
                    }
                }
            }
        }
        else if (sortBy == 1) {
            // Sort by last name
            Person temp;
            for (int i = 0; i < contacts.size(); i++) {
                for (int j = 0; j < contacts.size() - 1 - i; j++) {
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
                    if (contacts.get(j).getPhoneNumber().compareTo(contacts.get(j + 1).getPhoneNumber()) > 0) {
                        temp = contacts.get(j);
                        contacts.set(j, contacts.get(j + 1));
                        contacts.set(j + 1, temp);
                    }
                }
            }
        }
    }

    public Person searchByFirstName(String firstName) {
        for (Person p: contacts) {
            if (p.getFirstName().equals(firstName)) {
                return p;
            }
        }
        return null;
    }

    public Person searchByLastName(String lastName) {
        for (Person p: contacts) {
            if (p.getLastName().equals(lastName)) {
                return p;
            }
        }
        return null;
    }

    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person p: contacts) {
            if (p.getPhoneNumber().equals(phoneNumber)) {
                return p;
            }
        }
        return null;
    }

    public void listStudents() {
        ArrayList<Person> students = new ArrayList<Person>();
        for (Person p: contacts) {
            if (p instanceof Student) {
                students.add(p);
            }
        }
        for (Person s : students) {
            System.out.println(s.toString());
        }
    }

    public void test() {
        addContact(1, "Lily", "Kassaei", "1", 10, "tennis");
        addContact(1, "Sara", "Kassaei", "2", 10, "golf");
        addContact(2, "Baba", "Kass", "3", 100, "weights");
    }

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

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean wantsExit = false;
        while(!wantsExit) {
            printMenu();
            int choice = scanner.nextInt();
            if (choice == 0) {
                wantsExit = true;
            }
            else if (choice == 1) {
                addContactHelper();
            }
            else if (choice == 2) {
                sort(0);
                printContacts();
            }
            else if (choice == 3) {
                sort(1);
                printContacts();
            }
            else if (choice == 4) {
                sort(2);
                printContacts();
            }
            else if (choice == 5) {
                listStudents();
            }
            else if (choice == 6) {
                System.out.print("Enter a name:");
                scanner.nextLine();
                String firstName = scanner.nextLine();
                if (searchByFirstName(firstName) != null) {
                    System.out.print(searchByFirstName(firstName));
                }
                else {
                    System.out.print(firstName + " is not in the list.\n");
                }
            }
            else if (choice == 7) {
                System.out.print("Enter a last name:");
                scanner.nextLine();
                String lastName = scanner.nextLine();
                if (searchByLastName(lastName) != null) {
                    System.out.print(searchByLastName(lastName));
                }
                else {
                    System.out.print(lastName + " is not in the list.\n");
                }
            }
            else if (choice == 8) {
                System.out.print("Enter a phone number:");
                scanner.nextLine();
                String phoneNumber = scanner.nextLine();
                if (searchByPhoneNumber(phoneNumber) != null) {
                    System.out.print(searchByPhoneNumber(phoneNumber));
                }
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

    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        contactList.run();
    }
}
