// Employee Management System (Encapsulation + Constructors)

package EmployeeManagementSystem;

public class EmployeeTest {
    public static void main(String[] args) {

        System.out.println("===== Employee Management System =====");

        // 1️⃣ Default Constructor
        Employee e1 = new Employee();

        // 2️⃣ Parameterized Constructor
        Employee e2 = new Employee("Satinder Singh Sall", 101, 65000.0, "Development");

        // 3️⃣ Copy Constructor
        Employee e3 = new Employee(e2);

        System.out.println("\n===== Employee Details =====");

        System.out.println("\nEmployee 1:");
        e1.displayDetails();

        System.out.println("\nEmployee 2:");
        e2.displayDetails();

        System.out.println("\nEmployee 3 (Copy of Employee 2):");
        e3.displayDetails();

        // Apply a raise
        System.out.println("\nApplying 10% Raise to Employee 2...");
        e2.giveRaise(10);

        // Display updated details for Employee 2
        System.out.println("\nUpdated Employee 2 Details:");
        e2.displayDetails();
    }
}
