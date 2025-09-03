/*
 * Question - 2:
 * Write a program that reads a set of integers, and then prints
 * the sum of the even and odd integers.
*/

package assignments;

import java.util.Scanner;

public class questionAnswer2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter a number of total inputs : ");
        int number = scanner.nextInt();

        int evenSum = 0;
        int oddSum = 0;

        while (number > 0) {
            System.out.print("Enter the numbers: ");
            int currNum = scanner.nextInt();

            if (currNum % 2 == 0) {
                evenSum = evenSum + currNum;
            } else {
                oddSum = oddSum + currNum;
            }
            number--;
        }

        System.out.println("\nSum of even numbers are: " + evenSum);
        System.out.println("Sum of odd numbers are: " + oddSum);

        scanner.close();
    }
}
