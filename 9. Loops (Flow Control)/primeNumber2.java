/*
 * Question:
 * Check if a number is Prime or not.
*/

import java.util.Scanner;

public class primeNumber2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\tPrime Number Calculator:");
        System.out.print("Enter a number: ");
        int userNumber = scanner.nextInt();

        if (userNumber == 2) {
            System.out.println("\nThe number " + userNumber + " is prime.");
        } else {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(userNumber); i++) {
                if (userNumber % i == 0) { // n is a multiple of i (i not equal to 1 or userNumber)
                    isPrime = false;
                }
            }

            if (isPrime == true) {
                System.out.println("\nThe number " + userNumber + " is prime.");
            } else {
                System.out.println("\nThe number " + userNumber + " is not prime.");
            }
        }

        scanner.close();
    }
}
