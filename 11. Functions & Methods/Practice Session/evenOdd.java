//! Odd OR Even using Functions: Java

import java.util.Scanner;

public class evenOdd {
    public static boolean isEven(int n) {
        if (n % 2 == 1) {
            return false; // odd number
        } else {
            return true; // even number
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        boolean result = isEven(n);

        System.out.println(result);

        scanner.close();
    }
}
