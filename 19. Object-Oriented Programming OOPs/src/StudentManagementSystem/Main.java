package StudentManagementSystem;

import java.util.*;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        seedDemoData(); // optional; comment out if not needed
        while (true) {
            printMenu();
            int choice = readInt("Choose an option: ");
            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudent();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> listAll();
                case 6 -> listEligible();
                case 7 -> sortMenu();
                case 8 -> showStats();
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
            System.out.println();
        }
    }

    // -------- Menu & Options --------
    private static void printMenu() {
        System.out.println("======================================");
        System.out.println("      Student Management System");
        System.out.println("======================================");
        System.out.println("1. Add Student");
        System.out.println("2. View Student by Roll Number");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. List All Students");
        System.out.println("6. List Eligible Students");
        System.out.println("7. Sort & Display");
        System.out.println("8. Quick Stats");
        System.out.println("0. Exit");
        System.out.println("======================================");
    }

    private static void addStudent() {
        String name = readNonEmptyString("Enter name: ");
        int roll = readPositiveInt("Enter roll number (unique, > 0): ");
        if (findByRoll(roll) != null) {
            System.out.println("A student with roll " + roll + " already exists.");
            return;
        }
        float marks = readFloatInRange("Enter marks (0-100): ", 0, 100);
        float att = readFloatInRange("Enter attendance (0-100): ", 0, 100);

        try {
            Student s = new Student(name, roll, marks, att);
            students.add(s);
            System.out.println("Student added successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to add student: " + e.getMessage());
        }
    }

    private static void viewStudent() {
        int roll = readPositiveInt("Enter roll number to view: ");
        Student s = findByRoll(roll);
        if (s == null) System.out.println("No student found with roll " + roll);
        else {
            s.display();
            s.checkEligibility();
        }
    }

    private static void updateStudent() {
        int roll = readPositiveInt("Enter roll number to update: ");
        Student s = findByRoll(roll);
        if (s == null) {
            System.out.println("No student found with roll " + roll);
            return;
        }

        System.out.println("Leave field blank to keep current value.");
        String name = readOptionalString("New name [" + s.getName() + "]: ");
        String marksStr = readOptionalString("New marks 0-100 [" + s.getMarks() + "]: ");
        String attStr = readOptionalString("New attendance 0-100 [" + s.getAttendance() + "]: ");

        try {
            if (name != null) s.setName(name);
            if (marksStr != null) s.setMarks(parseFloatInRange(marksStr, 0, 100));
            if (attStr != null) s.setAttendance(parseFloatInRange(attStr, 0, 100));
            System.out.println("Student updated successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Update failed: " + e.getMessage());
        }
    }

    private static void deleteStudent() {
        int roll = readPositiveInt("Enter roll number to delete: ");
        Student s = findByRoll(roll);
        if (s == null) {
            System.out.println("No student found with roll " + roll);
            return;
        }
        students.remove(s);
        System.out.println("Student with roll " + roll + " deleted.");
    }

    private static void listAll() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        System.out.println("---- All Students ----");
        for (Student s : students) s.display();
    }

    private static void listEligible() {
        boolean any = false;
        System.out.println("---- Eligible Students (Marks ≥ 40, Attendance ≥ 75) ----");
        for (Student s : students) {
            if (s.isEligible()) {
                s.display();
                any = true;
            }
        }
        if (!any) System.out.println("None yet.");
    }

    private static void sortMenu() {
        if (students.isEmpty()) {
            System.out.println("No students to sort.");
            return;
        }
        System.out.println("""
                Sort by:
                1. Name (A→Z)
                2. Roll Number (Ascending)
                3. Marks (High→Low)
                4. Attendance (High→Low)
                """);
        int ch = readInt("Choose: ");
        switch (ch) {
            case 1 -> students.sort(Comparator.comparing(Student::getName, String.CASE_INSENSITIVE_ORDER));
            case 2 -> students.sort(Comparator.comparingInt(Student::getRollNumber));
            case 3 -> students.sort(Comparator.comparing(Student::getMarks).reversed());
            case 4 -> students.sort(Comparator.comparing(Student::getAttendance).reversed());
            default -> {
                System.out.println("Invalid option.");
                return;
            }
        }
        System.out.println("Sorted. Current list:");
        listAll();
    }

    private static void showStats() {
        if (students.isEmpty()) {
            System.out.println("No data for stats.");
            return;
        }
        int count = students.size();
        double avgMarks = students.stream().mapToDouble(Student::getMarks).average().orElse(0);
        Student top = students.stream().max(Comparator.comparing(Student::getMarks)).orElse(null);
        long eligibleCount = students.stream().filter(Student::isEligible).count();

        System.out.println("---- Quick Stats ----");
        System.out.println("Total students : " + count);
        System.out.printf("Average marks  : %.2f%n", avgMarks);
        System.out.println("Eligible count : " + eligibleCount);
        if (top != null) {
            System.out.println("Top performer  : " + top.getName() +
                    " (Roll " + top.getRollNumber() + ", Marks " + top.getMarks() + ")");
        }
    }

    // -------- Helpers --------
    private static Student findByRoll(int roll) {
        for (Student s : students) if (s.getRollNumber() == roll) return s;
        return null;
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static int readPositiveInt(String prompt) {
        while (true) {
            int v = readInt(prompt);
            if (v > 0) return v;
            System.out.println("Value must be > 0.");
        }
    }

    private static float readFloatInRange(String prompt, float min, float max) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                float f = Float.parseFloat(line);
                if (f < min || f > max) throw new IllegalArgumentException();
                return f;
            } catch (Exception e) {
                System.out.println("Enter a number between " + min + " and " + max + ".");
            }
        }
    }

    private static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine();
            if (line != null && !line.trim().isEmpty()) return line.trim();
            System.out.println("This field cannot be empty.");
        }
    }

    private static String readOptionalString(String prompt) {
        System.out.print(prompt);
        String line = sc.nextLine();
        if (line == null) return null;
        String t = line.trim();
        return t.isEmpty() ? null : t;
    }

    private static float parseFloatInRange(String text, float min, float max) {
        float f = Float.parseFloat(text.trim());
        if (f < min || f > max) throw new IllegalArgumentException("Value must be between " + min + " and " + max);
        return f;
    }

    private static void seedDemoData() {
        students.add(new Student("Aman", 101, 85f, 90f));
        students.add(new Student("Meera", 102, 61f, 82f));
        students.add(new Student("Rohit", 103, 33f, 70f));
        students.add(new Student("Zara", 104, 92f, 88f));
    }
}
