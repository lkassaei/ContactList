public class Person {
    // Declare instance variables of a Person
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // Contructor to initialize instance variables
    public Person(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    // Getter methods for all instance variables
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // To-String method that prints the first name, last name, and phone number of a Person
    public String toString() {
        return this.firstName + " " + this.lastName + " - #" + this.phoneNumber;
    }
}
