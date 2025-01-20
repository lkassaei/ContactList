public class Student extends Person{
    // Instance variables specific to a student
    private int grade;

    // Constructor that initializes all instance variables of the super class, Person, and also all instance variables of
    // a Student
    public Student(String firstName, String lastName, String phoneNumber, int grade) {
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }

    // Getter method for the grade of a Student
    public int getGrade() {
        return grade;
    }

    // An overridden to-string method that combines Person's to-string with the grade of the Student
    @Override
    public String toString() {
        return super.toString() + " Grade: " + this.grade;
    }
}
