/*
 * Question - 1:
 * Write a Java program to get a number from the user and print whether it is positive or negative.
*/

package assignments;

import java.util.Scanner;

public class questionSolution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter a number: ");
        float number = scanner.nextFloat();

        if (number > 0) {
            System.out.println("\nThe number " + number + " is positive number.");
        } else if (number == 0) {
            System.out.println(
                    "\nNumber 0 zero is a neutral integer, meaning it is neither positive nor negative. It is the only integer without a sign.");
        } else {
            System.out.println("\nThe number " + number + " is negative number.");
        }
    }
}
