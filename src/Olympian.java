public class Olympian extends Person{
    private String sport;

    public Olympian(String firstName, String lastName, String phoneNumber, String sport) {
        super(firstName, lastName, phoneNumber);
        this.sport = sport;
    }

    public String getSport() {
        return sport;
    }

    public String toString() {
        return super.toString() + " Sport: " + this.sport;
    }
}
