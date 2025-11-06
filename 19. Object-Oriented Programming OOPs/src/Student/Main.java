// 🎓 Example 2: Student Class

/*
🎯 Goal: Show how to structure and control access to student data.
Here, we’ll use access modifiers to safely manage name, age,
and grades.
*/

package Student;

class Student {
    private String name;
    private int age;
    private float percentage;

    // 🏗️ Constructor to set student details
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 🧾 Public methods to set and get data
    public void setMarks(int marks1, int marks2, int marks3) {
        percentage = (marks1 + marks2 + marks3) / 3.0f;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getPercentage() {
        return percentage;
    }

    // Display method
    public void showDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Percentage: " + percentage + "%");
    }
}

public class Main {
    public static void main(String[] args) {
        // 🎓 Create object
        Student s1 = new Student("Satinder Singh", 22);
        s1.setMarks(85, 90, 80);
        s1.showDetails();
    }
}
