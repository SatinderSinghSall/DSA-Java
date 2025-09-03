//! Sum of first 'n' natural numbers: Java

import java.util.Scanner;

public class sumOfNatural {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\tNatural Number Calculator:");
        System.out.print("Enter a number: ");
        int userInput_Number = scanner.nextInt();

        int i = 1;
        int sum = 0;
        while (i <= userInput_Number) {
            sum = sum + i;
            i++;
        }

        System.out.println("The sum of " + userInput_Number + " is : " + sum);
    }
}
