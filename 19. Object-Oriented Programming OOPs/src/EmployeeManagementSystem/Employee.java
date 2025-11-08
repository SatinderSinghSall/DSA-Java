package EmployeeManagementSystem;

public class Employee {
    // 🔒 Private Data Members (Encapsulation)
    private String name;
    private int id;
    private double salary;
    private String department;

    // 1️⃣ Default Constructor
    public Employee() {
        System.out.println("Default Constructor called.");
        this.name = "Not Assigned";
        this.id = 0;
        this.salary = 0.0;
        this.department = "Not Assigned";
    }

    // 2️⃣ Parameterized Constructor
    public Employee(String name, int id, double salary, String department) {
        System.out.println("Parameterized Constructor called.");
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.department = department;
    }

    // 3️⃣ Copy Constructor
    public Employee(Employee other) {
        System.out.println("Copy Constructor called.");
        this.name = other.name;
        this.id = other.id;
        this.salary = other.salary;
        this.department = other.department;
    }

    // 🧮 Business Logic Method — Apply Salary Raise
    public void giveRaise(double percent) {
        if (percent > 0) {
            this.salary += (salary * percent / 100);
            System.out.println("\nApplied a raise of " + percent + "% for " + name + ".");
        } else {
            System.out.println("Invalid raise percentage!");
        }
    }

    // 🧾 Display Employee Details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: ₹" + salary);
        System.out.println("Department: " + department);
    }

    // ✅ Getters and Setters (Encapsulation)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getId() { return id; }
    public void setId(int id) {
        if (id > 0) this.id = id;
        else System.out.println("Invalid ID!");
    }
    public double getSalary() { return salary; }
    public void setSalary(double salary) {
        if (salary >= 0) this.salary = salary;
        else System.out.println("Salary cannot be negative!");
    }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}
