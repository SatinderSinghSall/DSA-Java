//! Array Creation: Java

import java.util.Scanner;

public class javaArray {
    public static void main(String[] args) {
        // Array: Array Creation:
        int marks[] = new int[50];
        int numbers[] = { 1, 2, 3 };
        int moreNumbers[] = { 4, 5, 6 };
        String fruits[] = { "Apple", "Mango", "Orange" };

        // Array: Input Output:
        Scanner scanner = new Scanner(System.in);

        int studentMarks[] = new int[100];

        System.out.println("\n\tEnter your MARKS below:");

        System.out.print("Enter your Maths marks: ");
        studentMarks[0] = scanner.nextInt();

        System.out.print("Enter your Physics marks: ");
        studentMarks[1] = scanner.nextInt();

        System.out.print("Enter your Chemistry marks: ");
        studentMarks[2] = scanner.nextInt();

        System.out.println("\n\tDisplaying your MARKS below:");
        System.out.println("Your Maths marks is: " + studentMarks[0]);
        System.out.println("Your Physics marks is: " + studentMarks[1]);
        System.out.println("Your Chemistry marks is: " + studentMarks[2]);

        studentMarks[2] = 100;
        studentMarks[1] = studentMarks[1] + 1;

        System.out.println("\n\tDisplaying your MARKS below: UPDATED");
        System.out.println("Your Maths marks is: " + studentMarks[0]);
        System.out.println("Your Physics UPDATED marks is: " + studentMarks[1]);
        System.out.println("Your Chemistry UPDATED marks is: " + studentMarks[2]);

        System.out.println("\n\tStudent Percentage:");
        int percentage = (studentMarks[0] + studentMarks[1] + studentMarks[2]) / 3;
        System.out.println("Your percentage is: " + percentage + "%");
    }
}
