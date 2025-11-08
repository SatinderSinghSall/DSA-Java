// Constructors in Java:

public class Constructor {
    public static void main(String[] args) {
        Student3 s1 = new Student3("Satinder Singh");

        System.out.println("Student Name: " + s1.name);
    }
}

class Student3 {
    String name;
    int rollNumber;

    Student3(String name) {
        this.name = name;
    }
 }
