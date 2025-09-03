//! Function with Parameters: Java

import java.util.Scanner;

public class functionWithParameters {
    public static int calculateSum(int number1, int number2) { // parameter OR formal-parameter
        int sum = number1 + number2;
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the number 1: ");
        int number1 = scanner.nextInt();

        System.out.print("Enter the number 2: ");
        int number2 = scanner.nextInt();

        scanner.close();

        int sum = calculateSum(number1, number2); // arguments OR actual-parameters

        System.out.println("\nThe addition of: " + number1 + " + " + number2 + " = " + sum);
    }
}
