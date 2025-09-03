//! Largest of two numbers: Java

import java.util.Scanner;

public class largestOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the first number: ");
        float number1 = scanner.nextFloat();

        System.out.print("Enter the second number: ");
        float number2 = scanner.nextFloat();

        float result;
        if (number1 > number2) {
            result = number1;
        } else {
            result = number2;
        }

        System.out.println("\nThe largest number among: " + number1 + " and " + number2 + " is " + result);
    }
}
