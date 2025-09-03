//! Ternary Operator: Java

import java.util.Scanner;

public class ternaryOperator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter a number: ");
        float number = scanner.nextFloat();

        String result = (number % 2 == 0) ? "Even" : "Odd";

        System.out.println("The number " + number + " is " + result);
    }
}
