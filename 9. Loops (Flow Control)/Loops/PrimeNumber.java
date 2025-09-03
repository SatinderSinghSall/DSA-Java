package Loops;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Prime Number App =====");
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        boolean isPrime = true;

        for(int i = 2; i <= num - 1; i++) {
            if(num % i == 0) {
                isPrime = false;
            }
        }

        if(isPrime) {
            System.out.println("The number " + num + " is a PRIME number.");
        } else {
            System.out.println("The number " + num + " is NOT a prime number.");
        }
    }
}
