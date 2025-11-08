package StudentManagementSystem;

public class Student {
    private String name;
    private int rollNumber;
    private float marks;
    private float attendance;

    // No-arg constructor (keeps validation strict; uses a valid placeholder roll)
    public Student() {
        this("Unknown", 1, 0f, 0f);
        System.out.println("No-arg constructor called.");
    }

    // Parameterized constructor
    public Student(String name, int rollNumber, float marks, float attendance) {
        setName(name);
        setRollNumber(rollNumber);
        setMarks(marks);
        setAttendance(attendance);
        System.out.println("Parameterized constructor called.");
    }

    // Copy constructor
    public Student(Student other) {
        this(other.name, other.rollNumber, other.marks, other.attendance);
        System.out.println("Copy constructor called.");
    }

    // Setters with validation
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) this.name = "Unknown";
        else this.name = name.trim();
    }

    public void setRollNumber(int rollNumber) {
        if (rollNumber > 0) this.rollNumber = rollNumber;
        else throw new IllegalArgumentException("Roll number must be positive");
    }

    public void setMarks(float marks) {
        if (marks < 0 || marks > 100) throw new IllegalArgumentException("Marks must be 0-100");
        this.marks = marks;
    }

    public void setAttendance(float attendance) {
        if (attendance < 0 || attendance > 100) throw new IllegalArgumentException("Attendance must be 0-100");
        this.attendance = attendance;
    }

    // Getters
    public String getName() { return name; }
    public int getRollNumber() { return rollNumber; }
    public float getMarks() { return marks; }
    public float getAttendance() { return attendance; }

    public boolean isEligible() {
        return marks >= 40 && attendance >= 75;
    }

    public void checkEligibility() {
        if (isEligible()) System.out.println(name + " is eligible");
        else System.out.println(name + " is not eligible");
    }

    public void display() {
        System.out.println("Name: " + name + ", Roll: " + rollNumber +
                ", Marks: " + marks + ", Attendance: " + attendance);
    }

    // Useful for collections (uniqueness by roll number)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        return rollNumber == ((Student) o).rollNumber;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(rollNumber);
    }
}
