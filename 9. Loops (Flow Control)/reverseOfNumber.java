//! Print reverse of a number: Java

import java.util.Scanner;

public class reverseOfNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\tReverse of the given number:");

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        while (number > 0) {
            int lastDigit = number % 10;
            System.out.print(lastDigit + " ");
            number = number / 10;
        }

        System.out.println();
    }
}
