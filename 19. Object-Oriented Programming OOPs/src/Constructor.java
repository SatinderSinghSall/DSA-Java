// Constructors in Java:

public class Constructor {
    public static void main(String[] args) {
        Student3 s1 = new Student3("Satinder Singh");
        Student3 s2 = new Student3();
        Student3 s3 = new Student3(180);

        System.out.println("Student Name: " + s1.name);
    }
}

class Student3 {
    String name;
    int rollNumber;

    Student3() {
        System.out.println("Empty Constructor.");
    }

    Student3(String name) {
        this.name = name;
    }

    Student3(int rollNumber) {
        this.rollNumber = rollNumber;
    }
 }
