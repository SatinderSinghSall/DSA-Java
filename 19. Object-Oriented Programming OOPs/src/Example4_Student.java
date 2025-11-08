// Example 4: Student Management System

public class Example4_Student {
    public static void main(String[] args) {
        Student2 s1 = new Student2();

        s1.setName("Satinder Singh Sall");
        s1.setRollNumber(2570180);
        s1.setMarks(80.f);
        s1.setAttendance(80f);

        System.out.println("\n===== Exam Management System =====");
        System.out.println("\nStudent Name: " + s1.getName());
        System.out.println("Student Roll Number: " + s1.getRollNumber());
        System.out.println("Student Marks: " + s1.getMarks());
        System.out.println("Student Attendance: " + s1.getAttendance());

        System.out.println("\nEligibility Check:");
        s1.checkEligibility();
    }
}

class Student2 {
    private String name;
    private int rollNumber;
    private float marks;
    private float attendance;

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNumber(int rollNumber) {
        if(rollNumber > 0) {
            this.rollNumber = rollNumber;
        } else {
            System.out.println("Invalid roll number!");
        }
    }

    public void setMarks(float marks) {
        if(marks >= 0 && marks <= 100) {
            this.marks = marks;
        }
    }

    public void setAttendance(float attendance) {
        if(attendance >= 0 && attendance <= 100) {
            this.attendance = attendance;
        }
    }

    public void checkEligibility() {
        if(marks >= 40 && attendance >= 75) {
            System.out.println("Dear, " + name + " you are ELIGIBLE for SEE Exam.");
        } else {
            System.out.println("Dear, " + name + " you are NOT eligible for SEE Exam.");

            if(marks < 40) {
                System.out.println("Reason: Your marks are " + marks + ", which is below 40.");
            }
            if (attendance < 75) {
                System.out.println("Reason: Your attendance is " + attendance + " which is below 75% criteria.");
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public float getMarks() {
        return marks;
    }

    public float getAttendance() {
        return attendance;
    }
}
