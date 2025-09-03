// Sum of a & b user-input:

import java.util.Scanner;

public class SumInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter number 1: ");
        float num1 = scanner.nextFloat();

        System.out.print("Enter number 2: ");
        float num2 = scanner.nextFloat();

        float sum = num1 + num2;

        System.out.println("Sum of: " + num1 + " + " + num2 + " = " + sum);
    }
}
