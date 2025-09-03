//! Largest of three numbers: Java

import java.util.Scanner;

public class largestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the number 1: ");
        float number1 = scanner.nextFloat();

        System.out.print("Enter the number 2: ");
        float number2 = scanner.nextFloat();

        System.out.print("Enter the number 3: ");
        float number3 = scanner.nextFloat();

        float result;
        if (number1 > number2 && number1 > number3) {
            result = number1;
        } else if (number2 > number1 && number2 > number3) {
            result = number2;
        } else {
            result = number3;
        }

        System.out.println(
                "\nThe largest number among: " + number1 + ", " + number2 + " and " + number3 + " = " + result);
    }
}
