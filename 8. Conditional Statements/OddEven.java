//! Odd and Even: Java

import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter a number: ");
        float number = scanner.nextFloat();

        if (number % 2 == 0) {
            System.out.println("\nThe number " + number + " is: Even!");
        } else {
            System.out.println("The number " + number + " is: Odd!");
        }
    }
}
