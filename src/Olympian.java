public class Olympian extends Person{
    // Instance variables specific to an olympian
    private String sport;

    // Constructor that initializes all instance variables of the super class, Person, and also all instance variables of
    // an Olympian
    public Olympian(String firstName, String lastName, String phoneNumber, String sport) {
        super(firstName, lastName, phoneNumber);
        this.sport = sport;
    }

    // Getter method for the sport of an Olympian
    public String getSport() {
        return sport;
    }

    // An overridden to-string method that combines Person's to-string with the sport of the Olympian
    public String toString() {
        return super.toString() + " " + this.sport;
    }
}
