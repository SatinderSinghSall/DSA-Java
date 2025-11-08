package Student2;

public class Student {
    private String name;
    private int rollNumber;
    private float marks;

    // 1️⃣ No-Argument Constructor
    public Student() {
        System.out.println("Default Constructor called.");
        name = "Not Assigned";
        rollNumber = 0;
        marks = 0f;
    }

    // 2️⃣ Parameterized Constructor
    public Student(String name, int rollNumber, float marks) {
        System.out.println("Parameterized Constructor called.");
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // 3️⃣ Copy Constructor
    public Student(Student other) {
        System.out.println("Copy Constructor called.");
        this.name = other.name;
        this.rollNumber = other.rollNumber;
        this.marks = other.marks;
    }

    public void display() {
        System.out.println("\nName: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
    }

    public static void main(String[] args) {
        Student s1 = new Student();  // No-arg constructor
        Student s2 = new Student("Satinder", 2570180, 85.5f);  // Parameterized
        Student s3 = new Student(s2);  // Copy constructor

        s1.display();
        s2.display();
        s3.display();
    }
}
