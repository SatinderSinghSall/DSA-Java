//! Student Pass or Fail: Java

import java.util.Scanner;

public class passOrFail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\tStudent Grade Calculator:");

        System.out.print("Enter your marks: ");
        float studentMarks = scanner.nextFloat();

        String grade = (studentMarks >= 33) ? "PASS" : "FAIL";

        System.out.println("\nYou are: " + grade);
    }
}
